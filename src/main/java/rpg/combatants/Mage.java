package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.weapon.MageStaff;
import rpg.stuff.equipment.weapon.Staff;

public class Mage extends SpellCaster {

    public Mage(String name){
        super(name);
        this.sign = "\uD83E\uDDD9";
        this.weapon = new MageStaff();
    }




}
