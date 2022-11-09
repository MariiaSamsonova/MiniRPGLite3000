package rpg.stuff.consumables;

public class Food extends Consumable {

    private int health;

    public Food(int amount) {
        super(amount);
        this.sign = "\uD83C\uDF4F";
        health = 20;
    }

    public void improve() {
        this.health += 10;
    }

    public int getHealthPoints() {
        return this.health;
    }
}
