package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.armor.Shield;
import rpg.stuff.equipment.weapon.Sword;
import utils.InputParser;

public class Warrior extends Hero {

    private Shield shield;
    public Warrior(String name){
        super(name);
        this.sign = "⚔";
        this.shield = new Shield();
        this.weapon = new Sword();

    }

    @Override
    public void printMoveInfo(InputParser ip){
        if(this.shield.isServiceable()){
            ip.print("Player " + this.name + " make move");
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            ip.print("Your weapon:" + weapon.toString() + ". Damage: " + (this.damage + weapon.getPlusDamage()));
            ip.print("Your armor:" + this.armor + ", " + this.shield + ". " +
                    "State: " + this.armor.getState() + "%. " +
                    "Protection: " + (int)((1 - this.shield.getDamagePart()) * 100) + "%");
        }
        else super.printMoveInfo(ip);

    }

    @Override
    public void beHit(int percent) {
        if(this.shield.isServiceable())
        {
            int rest = this.shield.beHit(percent);
            super.beHit(rest);
        }
        else{
            super.beHit(percent);
        }


    }

}
