import rpg.Game;
import rpg.Hero;
import utils.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Main {

    InputParser ip;
    public static void main(String args[]) {//TODO это должно быть в Game но это не точно
        Game game = new Game();

        game.ip.print("Enter number of heroes");
        int n = game.ip.getInteger();

        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 1; i <= n; i++) {
            Hero hero = null;
            String name = null;
            while (hero == null) {
                game.ip.print("Enter name of hero №" + i);
                name = game.ip.getString();
                game.ip.print("Enter class of hero №" + i + " (1 - warrior, 2 - mage, 3 - hunter, 4 - healer)");
                hero = Game.createHero(game.ip.getString(), name);
            }
            heroes.add(hero);
        }
        game.setHeroes(heroes);

        while (game.getFightNumber() < 5 && game.getPlayersNumber() > 0) {//default number of fights = 5 TODO set number of fights
            game.setEnemies(n);
            game.setMoveOrder();
            game.ip.print(game.combatants.toString());
            while (game.getPlayersNumber() > 0 && game.getEnemiesNumber() > 0)//1 fight
            {
                game.ip.doSomethingToContinue();
                game.ip.print("Fight №" + game.getFightNumber());

                List<Integer> order = game.setMoveOrder();

                for (int i : order) {
                    if (game.combatants.get(i).isAlive()) {
                        game.combatants.get(i).makeMove(game);
                        game.ip.print(game.combatants.toString());
                        game.ip.doSomethingToContinue();
                    }
                }
            }
            game.endFight();
        }
    }
}
