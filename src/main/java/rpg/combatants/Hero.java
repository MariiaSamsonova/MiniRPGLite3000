package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.armor.Armor;
import rpg.stuff.equipment.weapon.Weapon;
import utils.InputParser;

public abstract class Hero extends Combatant {

    Weapon weapon;
    protected Armor armor;


    public Hero(String name) {
        super(name);
        this.armor = new Armor();
        this.damage = 15;
    }//each has weapon, armor, food and potion

    @Override
    public void makeMove(Game game) throws Exception {//TODO убрать Exception -> safe
        game.printGameInfo();
        printMoveInfo(game.ip);
        game.ip.print("0 - hit, 1 - eat(+25 health)");

        int action = game.ip.getInteger();
        switch (action) {
            case 0:
                hit(game);
                return;
            case 1:
                eat(game);
                return;
            default:
                throw new Exception();
        }


    }



    public void printMoveInfo(InputParser ip) {
        ip.print("Player " + this.name + " make move");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ip.print("Your weapon: " + weapon.toString() + ". Damage: " + (this.damage + weapon.getPlusDamage()));
        ip.print("Your armor: " + this.armor + ". " +
                        "State: " + this.armor.getState() + "%. " +
                        "Protection: " + (int)(100 - this.armor.getDamagePart() * 100) + "%");
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


    public void eat(Game game)
    {
        if(game.food.left())
        {
            game.food.use();
            this.health += 15;
            if(this.health > 100) this.health = 100;
        }
    }


    @Override
    public void beHit(int percent) {
        if(this.armor.isServiceable())
        {
            int rest = this.armor.beHit(percent);
            super.beHit((int)(percent * this.armor.getDamagePart()));
            super.beHit(rest);
        }
        else super.beHit(percent);


    }

    //make move
    // атаковать,
    // TODO защищаться

    // или даже использовать расходные материалы, такие как поедание lembas1 или другую пищу, чтобы восстановить свою жизнь,
    // TODO или выпить зелье, чтобы восстановить ману заклинателей



    //Охотник стреляет стрелами (пока у него не останется ни одной),
    //Воин бьет в TODO ближнем бою,
    // Целитель исцеляет заклинаниями,
    // а Маг использует магию против врагов.

    // TODO Если команда выигрывает бой, каждый персонаж может выбрать один из нескольких вариантов:
    //• увеличить наносимый вами урон;
    //• повысить нашу устойчивость к атакам;
    //• повысить эффективность зелий и еды;
    //• увеличить количество зелий или еды;
    //• увеличить количество стрел (для Охотника),
    //• уменьшить расход маны для ведьмаков, или увеличить эффективность их заклинаний.
}
