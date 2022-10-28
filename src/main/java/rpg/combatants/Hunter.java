package rpg.combatants;

import rpg.Game;
import rpg.stuff.consumables.Arrows;
import rpg.stuff.equipment.weapon.Bow;

public class Hunter extends Hero {

    private Arrows arrows;

    public Hunter(String name){
        super(name);
        this.sign = "🏹";
        this.weapon = new Bow();
        arrows = new Arrows(50);
    }


}
