package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.armor.Shield;
import rpg.stuff.equipment.weapon.Sword;

public class Warrior extends Hero {

    private Shield shield;
    public Warrior(String name){
        super(name);
        this.sign = "⚔";
        this.shield = new Shield();
        this.weapon = new Sword();

    }

}
