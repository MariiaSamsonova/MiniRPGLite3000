package rpg.stuff.consumables;

public class Food extends Consumable {

    public Food(int amount) {
        super(amount);
        this.sign = "\uD83C\uDF4F".repeat(5);
    }
}
