package rpg.stuff.consumables;

public class Potions extends Consumable {
    private int mana;
    public Potions(int amount) {
        super(amount);
        this.sign = "\uD83C\uDF75";
        this.mana = 20;
    }

    public void improve() {
        this.mana += 10;
    }

    public int getManaPoints() {
        return this.mana;
    }
}
