package rpg.combatants;

import rpg.Game;

public abstract class Combatant {

    String name;
    Combatant(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    String sign;
    int health = 100;

    int damage;

    public abstract void makeMove(Game game) throws Exception; //return the amount of damage

    // если противник не выбран ход по типу: похилить, покушать, надеть доспехи
    public boolean isAlive() {
        if (this.health == 0){
            this.sign = "\uD83D\uDC7B";
            return false;
        }
        return true;
    }

    public void beHit(int percent) {
        this.health -= percent;
        if(this.health < 0)
        {
            this.health = 0;
        }
        isAlive();
    }

    @Override
    public String toString()
    {
        return this.name + " " + this.sign + "(" + this.health + "%)";
    }
}
