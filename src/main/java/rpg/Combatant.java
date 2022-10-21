package rpg;

public abstract class Combatant {
    private int livesNumber = 5;
    public abstract void makeMove(Combatant combatant); //return the amount of damage
                                                        // если противник не выбран ход по типу: похилить, покушать, надеть доспехи
    public boolean isAlive(){
        if(this.livesNumber == 0) return false;
        return true;
    }
}
