package rpg.combatants;

import rpg.Game;
import rpg.stuff.equipment.weapon.Staff;

abstract class SpellCaster extends Hero {


    SpellCaster(String name) {
        super(name);
    }


    @Override
    public void makeMove(Game game){
        printMoveInfo(game.ip);
        game.ip.print("Heal: " + this.weapon.getHeal());
        game.ip.print("Enter 0 to hit or 1 to heal");
        if(game.ip.getInteger() == 0){
            hit(game);
        }
        else {
            game.choseHero().heal();
        }
    }

}
