package rpg.stuff.equipment.armor;

public class Armor {
    String sign = "simple armor";

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
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return this.sign;
    }

    public int beHit(int damage){
        this.state -= damage;
        if(this.state < 0) return -1 * this.state;
        return 0;
    }

    public int getState() {
        return this.state;
    }

    public void improve(double percent){
        this.damagePart -= percent;
    }

}
