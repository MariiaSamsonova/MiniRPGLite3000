package rpg.stuff.equipment.weapon;

public abstract class Weapon {

    String sign;
    int plusDamage;

    public int getPlusDamage(){
        return plusDamage;
    }


    protected Weapon(){
        plusDamage = 10;
    }

    @Override
    public String toString(){
        return this.sign;
    }

    public int getHeal(){
        return 0;
    }
}
