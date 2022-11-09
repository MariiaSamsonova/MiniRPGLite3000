package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.weapon.Bow;
import utils.InputParser;

public class Hunter extends Hero {


    public Hunter(String name){
        super(name);
        this.sign = "🏹";
        this.weapon = new Bow(3);
    }

    @Override
    public void printMoveInfo(InputParser ip){
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

    @Override
    public void hit(Game game) {
        Bow bow = (Bow) this.weapon;
        bow.isServiceable();
        super.hit(game);
        if(bow.isServiceable()) bow.makeShoot();
    }

    @Override
    public void doAction(Game game) {
        game.ip.print("0 - increase damage(+10), 1 - improve armor(+10%), " +
                "2 - improve food(+10 health), 3 - improve points(+10 mana), 4 - add food(3), 5 - add points(3)" +
                "6 - add arrows(10)");//TODO amount(?)
        switch (game.ip.getInteger()){
            case 0:
                increaseDamage(10);
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
                return;
            case 6:
                Bow bow = (Bow) this.weapon;
                bow.addArrows(10);;
        }
    }

}
