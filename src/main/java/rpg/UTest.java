package rpg;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UTest {

    Game game = new Game();
    int playersNumber = 0;

    @Test
    public void testPlayersNumber()
    {
        ArrayList<String> strings = new ArrayList<>();
        List<Hero> heroesClasses = new ArrayList<Hero>();
        heroesClasses.add(Game.createHero("Mage", null)); playersNumber++;
        heroesClasses.add(Game.createHero("Mage", null)); playersNumber++;
        heroesClasses.add(Game.createHero("Hunter", null)); playersNumber++;
        heroesClasses.add(Game.createHero("Healer", null)); playersNumber++;
        heroesClasses.add(Game.createHero("Warrior", null)); playersNumber++;

        game.setHeroes(heroesClasses);
        assertEquals(playersNumber, game.getPlayersNumber());
    }

    @Test
    public void testEnemiesNumber()
    {
        game.setEnemies(playersNumber);

        assertEquals(playersNumber, game.getEnemiesNumber());

        for(int i = 1; i < 5; i++)
        {
            game.endFight();
            game.setEnemies(playersNumber);
            assertEquals(playersNumber + i, game.getEnemiesNumber());
        }





    }
}
