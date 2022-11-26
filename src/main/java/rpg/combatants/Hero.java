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

    public void increaseDamage(int plusDamage){
        this.damage += plusDamage;
    }

    @Override
    public void makeMove(Game game) throws Exception {//TODO убрать Exception -> safe
        game.printGameInfo();
        printMoveInfo(game.ip);
        while(true){
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
                    game.ip.print("Wrong input, try again");
            }
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
            this.health += game.food.getHealthPoints();
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

    public void improveArmor() {
        this.armor.improve(0.1);
    }

    public void doAction(Game game) {
        game.ip.print("0 - increase damage(+10), 1 - improve armor(+10%), " +
                "2 - improve food(+10 health), 3 - improve points(+10 mana), 4 - add food, 5 - add points");
        switch (game.ip.getInteger()){
            case 0:
                increaseDamage(10);//10?
                return;
            case 1:
                improveArmor();
                return;
            case 2:
                game.food.improve();
                return;
            case 3:
                game.potions.improve();
                return;
            case 4:
                game.food.add(3);
                return;
            case 5:
                game.potions.add(3);
        }
    }
    //• уменьшить расход маны для mage and healer, или увеличить эффективность их заклинаний.

    //make move
    // атаковать,
    // TODO защищаться

    // или даже использовать расходные материалы, такие как поедание lembas1 или другую пищу, чтобы восстановить свою жизнь,
    // или выпить зелье, чтобы восстановить ману заклинателей



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
