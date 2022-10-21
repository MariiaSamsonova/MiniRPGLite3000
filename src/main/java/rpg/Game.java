package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.*;

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
        for (int i = 0; i < n; i++) {
            Enemy enemy = createEnemy();// TODO на последнем уровне босс
            this.combatants.add(enemy);
        }
    }

    private Enemy createEnemy() {
        return new Enemy();
    }

    public void setHeroes(int n, List<String> heroesClasses) {
        for (int i = 0; i < n; i++) {
            Hero hero = createHero(heroesClasses.get(i));
            this.combatants.add(hero);
        }
    }

    private Hero createHero(String heroClass) {//TODO enum (или посмотреть паттерны)

        switch (heroClass) {
            case "Warrior":
                return new Warrior();
            case "Mage":
                return new Mage();
            case "Healer":
                return new Healer();
            case "Hunter":
                return new Hunter();
            default:
                return null;//no default value
        }

    }

    public Enemy choseEnemy() {
        InputParser ip = new ConsoleParser();
        ip.print("Enter the number of enemy whom you want to attack, or 0 for other move");
        if (ip.getInteger() == 0)
        {
            return null;
        }
        return (Enemy) this.combatants.get(getPlayerNumber() + ip.getInteger());
    }

    public int getEnemiesNumber() {
        return this.combatants.size() - getPlayerNumber();
    }

    public int getPlayerNumber() {
        int n = 0;
        for (int i = 0; this.combatants.get(i) instanceof Hero; i++) {
            if (this.combatants.get(i).isAlive()) {
                n++;
            }
        }
        return n;
    }

    public List setMoveOrder() {

        List<Integer> order = new ArrayList<Integer>();
        for (int i = this.combatants.size(); i > 0; i--) {
            order.add(i);
        }
        Collections.shuffle(order);
        return order;

    }

    public void startNextLevel() {
        this.fight++;
    }
}
