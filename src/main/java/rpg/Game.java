package rpg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.*;

public class Game {

    private int fight;
    private List<Combatant> combatants;

    public Game() {
        this.fight = 0;
        this.combatants = new ArrayList<Combatant>();
    }

    private void setEnemies(int n) {
        for (int i = 0; i < n; i++) {
            Enemy enemy = createEnemy();// TODO на последнем уровне босс
            this.combatants.add(enemy);
        }
    }

    private Enemy createEnemy() {
        return new Enemy();
    }

    private void setHeroes(int n, List<String> heroesClasses) {
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

    public void play(int n, List<String> heroesClasses) {
        setHeroes(n, heroesClasses);

        while (this.fight < 5 && this.getPlayerNumber() > 0) {//default number of fights = 5 TODO set number of fights
            setEnemies(n);
            setMoveOrder();

            while (this.getPlayerNumber() > 0 && this.getEnemiesNumber() > 0)//1 fight
            {
                List<Integer> order = setMoveOrder();

                for (int i : order) {
                    if (this.combatants.get(i).isAlive()) {
                        this.combatants.get(i).makeMove(choseEnemy());
                    }
                }
            }
            this.fight++;
        }
    }

    private Enemy choseEnemy() {
        if (ConsoleParser.getInteger() == 0)
        {
            return null;
        }
        return (Enemy) this.combatants.get(getPlayerNumber() + ConsoleParser.getInteger());
    }

    private int getEnemiesNumber() {
        return this.combatants.size() - getPlayerNumber();
    }

    private int getPlayerNumber() {
        int n = 0;
        for (int i = 0; this.combatants.get(i) instanceof Hero; i++) {
            if (this.combatants.get(i).isAlive()) {
                n++;
            }
        }
        return n;
    }

    private List setMoveOrder() {

        List<Integer> order = new ArrayList<Integer>();
        for (int i = this.combatants.size(); i > 0; i--) {
            order.add(i);
        }
        Collections.shuffle(order);
        return order;

    }
}
