package rpg;

import utils.ConsoleParser;
import utils.InputParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    public static InputParser ip = new ConsoleParser();//TODO or GUIParser| переименовать
    private int fight;
    private List<Consumable> consumables;
    public List<Combatant> combatants;

    public Game() {
        this.fight = 0;
        this.combatants = new ArrayList<>();
        this.consumables = new ArrayList<>();
        consumables.add(new Food());
        consumables.add(new Potions());
    }

    public int getFightNumber() {
        return fight + 1;
    }

    public void setEnemies(int n) {
        this.combatants = this.combatants.subList(0, getPlayersNumber());
        for (int i = 0; i < n + this.fight; i++) {
            Enemy enemy = createEnemy(String.valueOf(i + 1));
            this.combatants.add(enemy);
        }
    }

    private Enemy createEnemy(String name) {
        return new Enemy(name);
    }// TODO на последнем уровне босс

    public void setHeroes(List<Hero> heroesClasses) {
        this.combatants.addAll(heroesClasses);
    }

    public static Hero createHero(String heroClass, String name) {//TODO enum (или посмотреть паттерны)

        switch (heroClass) {
            case "Warrior", "warrior", "1":
                return new Warrior(name);
            case "Mage", "mage", "2":
                return new Mage(name);
            case "Healer", "healer", "4":
                return new Healer(name);
            case "Hunter", "hunter", "3":
                return new Hunter(name);
            default:
                return null;//no default value
        }

    }

    public Enemy choseEnemy() {
        InputParser ip = new ConsoleParser();
        ip.print("Enter the number of enemy whom you want to attack, or 0 for other move");
        int enemyNumber = ip.getInteger();
        if (enemyNumber == 0)
        {
            return null;
        }
        return (Enemy) this.combatants.get(getPlayersNumber() + enemyNumber - 1);
    }

    public int getEnemiesNumber() {
        int n = 0;
        for (int i = getPlayersNumber(); i < this.combatants.size(); i++) {
            if (this.combatants.get(i).isAlive()) {
                n++;
            }
        }
        return n;
    }

    public int getPlayersNumber() {
        int n = 0;
        for (int i = 0; i < this.combatants.size() && this.combatants.get(i) instanceof Hero ; i++) {
            if (this.combatants.get(i).isAlive()) {
                n++;
            }
        }
        return n;
    }

    public List setMoveOrder() {

        List<Integer> order = new ArrayList<Integer>();
        for (int i = this.combatants.size()-1; i >= 0; i--) {
            order.add(i);
        }
        Collections.shuffle(order);
        return order;

    }

    public void endFight() {

        if(this.getPlayersNumber() > 0){
            ip.print("WIN in the fight №" + (this.fight + 1));
            ip.print("Next fight: ");
        }
        else {
            ip.print("GameOver");
        }

        this.fight++;
    }


}
