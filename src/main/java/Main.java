import rpg.Game;
import utils.ConsoleParser;
import utils.InputParser;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[])
    {
        Game game = new Game();
        InputParser ip = new ConsoleParser();//or GUIParser!!!
        ip.print("Enter number of heroes");
        int n = ip.getInteger();
        List<String> heroesClasses = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            ip.print("Enter class of " + i + " hero");
            heroesClasses.add(ip.getString());
        }
        game.setHeroes(n, heroesClasses);

        while (game.getFightNumber() < 5 && game.getPlayerNumber() > 0) {//default number of fights = 5 TODO set number of fights
            game.setEnemies(n);
            game.setMoveOrder();

            while (game.getPlayerNumber() > 0 && game.getEnemiesNumber() > 0)//1 fight
            {
                List<Integer> order = game.setMoveOrder();

                for (int i : order) {
                    if (game.combatants.get(i).isAlive()) {
                        game.combatants.get(i).makeMove(game.choseEnemy());
                    }
                }
            }
            game.startNextLevel();
        }
    }
}
