package rpg.stuff.consumables;

public class Potions extends Consumable {
    public Potions(int amount) {
        super(amount);
        this.sign = "\uD83C\uDF75".repeat(amount);
    }
}
