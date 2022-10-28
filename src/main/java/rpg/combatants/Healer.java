package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.weapon.HealerStaff;

public class Healer extends SpellCaster {

    public Healer(String name){
        super(name);
        this.sign = "\uD83E\uDDDD";
        this.weapon = new HealerStaff();
    }//each has weapon, armor, food and potion


}
