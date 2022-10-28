package rpg.stuff.consumables;

public abstract class Consumable {
    private int amount;
    String sign;

    Consumable(int amount){
        this.amount = amount;
    }

    public Boolean left()
    {
        if(this.amount > 0){
            return true;
        }
        else return false;
    }

    @Override
    public String toString(){
        return this.sign;
    }
}
