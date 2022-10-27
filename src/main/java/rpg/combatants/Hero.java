package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.Weapon;

import java.util.ArrayList;
import java.util.List;

public abstract class Hero extends Combatant {




    List<Weapon> weapons;
    public Hero(String name) {
        super(name);
        this.weapons = new ArrayList<Weapon>();
        //this.equipment.add(new Armor());
    }//each has weapon, armor, food and potion

    @Override
    public void makeMove(Game game)
    {
        System.out.println("Player " + this.name + " make move");
        game.choseEnemy().beHit(50);//TODO разные для разных классов

    }


    //make move
    // атаковать,
    // защищаться

    // или даже использовать расходные материалы, такие как поедание lembas1 или другую пищу, чтобы восстановить свою жизнь,
    // или выпить зелье, чтобы восстановить ману заклинателей



    //Охотник стреляет стрелами (пока у него не останется ни одной),
    //Воин бьет в ближнем бою,
    // Целитель исцеляет заклинаниями,
    // а Маг использует магию против врагов.

    //Если команда выигрывает бой, каждый персонаж может выбрать один из нескольких вариантов:
    //• увеличить наносимый вами урон;
    //• повысить нашу устойчивость к атакам;
    //• повысить эффективность зелий и еды;
    //• увеличить количество зелий или еды;
    //• увеличить количество стрел (для Охотника),
    //• уменьшить расход маны для ведьмаков, или увеличить эффективность их заклинаний.
}