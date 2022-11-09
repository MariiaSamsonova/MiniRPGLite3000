package rpg.stuff.consumables;

public abstract class Consumable {
    private int amount;
    String sign;

    Consumable(int amount){
        this.amount = amount;
    }

    public Boolean left()
    {
        return (this.amount > 0);
    }

    @Override
    public String toString(){
        return this.sign.repeat(this.amount);
    }

    public void use() {
        this.amount--;
    }

    public void add(int amount){
        this.amount += amount;
    }
}
