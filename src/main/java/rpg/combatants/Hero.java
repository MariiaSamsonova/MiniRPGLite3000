package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.armor.Armor;
import rpg.stuff.equipment.weapon.Weapon;
import utils.InputParser;

public abstract class Hero extends Combatant {

    Weapon weapon;
    private Armor armor;
    int damage;

    public Hero(String name) {
        super(name);
        this.armor = new Armor();
        this.damage = 15;
    }//each has weapon, armor, food and potion

    @Override
    public void makeMove(Game game)
    {
        printMoveInfo(game.ip);
        hit(game);

    }

    public void printMoveInfo(InputParser ip){
        ip.print("Player " + this.name + " make move");
        ip.print("Your weapon:" + weapon.toString());
    }
   // public abstract void hitSpecifically(Game game);

    public void hit(Game game){
        game.choseEnemy().beHit(this.damage + this.weapon.getPlusDamage());
    }

    public void heal() {
        this.health += 50;
        if(this.health > 100){
            this.health = 100;
        }
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
