package rpg.stuff.equipment.armor;

public class Armor {
    String sign = "";

    private int state;
    double damagePart;

    public double getDamagePart(){
        return this.damagePart;
    }
    public Armor(){
        this.state = 100;
        this.damagePart = 0.8;
    }

    public Boolean isServiceable(){
        if(this.state > 0)
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        return this.sign;
    }

    public void beHit(int damage){
        this.state -= damage * this.damagePart;
    }
}
