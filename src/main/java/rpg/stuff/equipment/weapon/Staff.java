package rpg.stuff.equipment.weapon;

import rpg.combatants.Hero;

public abstract class Staff extends Weapon{
    int heal;
    public Staff()
    {
        this.heal = 10;
        this.sign = "⚚";
    }

    @Override
    public int getHeal(){
        return this.heal;
    }



}
