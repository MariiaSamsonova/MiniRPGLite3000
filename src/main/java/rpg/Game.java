package rpg;

import utils.ConsoleParser;
import utils.InputParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

    private int fight;
    public List<Combatant> combatants;

    public Game() {
        this.fight = 0;
        this.combatants = new ArrayList<Combatant>();
    }

    public int getFightNumber() {
        return fight;
    }

    public void setEnemies(int n) {
        this.combatants = this.combatants.subList(0, getPlayersNumber());
        for (int i = 0; i < n + this.fight; i++) {
            Enemy enemy = createEnemy();
            this.combatants.add(enemy);
        }
    }

    private Enemy createEnemy() {
        return new Enemy();
    }// TODO на последнем уровне босс

    public void setHeroes(List<Hero> heroesClasses) {
        this.combatants.addAll(heroesClasses);
    }

    public static Hero createHero(String heroClass) {//TODO enum (или посмотреть паттерны)

        switch (heroClass) {
            case "Warrior", "warrior":
                return new Warrior();
            case "Mage", "mage":
                return new Mage();
            case "Healer", "healer":
                return new Healer();
            case "Hunter", "hunter":
                return new Hunter();
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

    public void startNextLevel() {
        InputParser ip = new ConsoleParser();//TODO or GUIParser
        ip.print("WIN in the fight №" + (this.fight + 1));
        this.fight++;
    }
}
