import rpg.Game;
import rpg.Hero;
import utils.ConsoleParser;
import utils.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Main {//TODO это должно быть в Game
    public static void main(String args[])
    {
        Game game = new Game();

        InputParser ip = new ConsoleParser();//TODO or GUIParser
        ip.print("Enter number of heroes");
        int n = ip.getInteger();

        List<Hero> heroes = new ArrayList<Hero>();
        for (int i = 1; i <= n; i++) {
            Hero hero = null;
            while(hero == null)
            {
                ip.print("Enter class of " + i + " hero");
                hero = Game.createHero(ip.getString());
            }
            heroes.add(hero);
        }
        game.setHeroes(heroes);

        while (game.getFightNumber() < 5 && game.getPlayersNumber() > 0) {//default number of fights = 5 TODO set number of fights
            game.setEnemies(n);
            ip.print(game.combatants.toString());
            ip.print("enemy1 is alive: " + game.combatants.get(game.getPlayersNumber()).isAlive());
            game.setMoveOrder();

            while (game.getPlayersNumber() > 0 && game.getEnemiesNumber() > 0)//1 fight
            {
                List<Integer> order = game.setMoveOrder();

                for (int i : order) {
                    if (game.combatants.get(i).isAlive()) {
                        game.combatants.get(i).makeMove(game);
                    }
                }
            }
            game.startNextLevel();//TODO maybe перед боем
        }
    }
}
