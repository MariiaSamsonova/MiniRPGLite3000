package rpg;

public abstract class Combatant {
    private int livesNumber = 2;//default 2 TODO more

    public abstract void makeMove(Game game); //return the amount of damage

    // если противник не выбран ход по типу: похилить, покушать, надеть доспехи
    public boolean isAlive() {
        if (this.livesNumber == 0) return false;
        return true;
    }

    public void beHit() {
        this.livesNumber--;
    }
}
