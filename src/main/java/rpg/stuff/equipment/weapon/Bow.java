package rpg.stuff.equipment.weapon;

import rpg.stuff.consumables.Arrows;

public class Bow extends Weapon{

    private Arrows arrows;

    public Bow(int arrowsAmount){
        this.plusDamage += 40;
        this.sign = "\uD83C\uDFF9";
        this.arrows = new Arrows(arrowsAmount);
    }

    public Boolean isServiceable(){
        if(!arrows.left()){
            this.plusDamage = 0;
        }
        return arrows.left();
    }

    public void makeShoot(){
        this.arrows.use();
    }
    public void addArrows(int n){
        arrows.add(n);
    }

    @Override
    public String toString(){
        return this.sign + " " + arrows.toString();
    }


}
