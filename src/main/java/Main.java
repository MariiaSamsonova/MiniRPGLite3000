import rpg.Game;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[])
    {
        Game game = new Game();
        int n = 0;                              //TODO
        game.setHeroes(0, new ArrayList<>());//TODO input n - playersNumber; List of classes

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
