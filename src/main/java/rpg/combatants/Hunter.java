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


}
