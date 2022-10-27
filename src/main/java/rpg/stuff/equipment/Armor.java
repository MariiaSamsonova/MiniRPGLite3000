package rpg.stuff.equipment;

public class Armor extends Weapon {

    private int state;
    double damagePart;

    Armor(){
        this.state = 100;
        this.damagePart = 0.8;
    }

    public void beHit(double damage){
        this.state -= (int) (damage * this.damagePart);
    }

    public Boolean isServiceable(){
        if(this.state > 0)
        {
            return false;
        }
        return true;
    }
}
