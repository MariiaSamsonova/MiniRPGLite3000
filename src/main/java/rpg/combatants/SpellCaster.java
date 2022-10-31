package rpg.combatants;

import rpg.Game;
import utils.InputParser;

abstract class SpellCaster extends Hero {

    int mana;

    SpellCaster(String name) {
        super(name);
        this.mana = 100;
    }


    @Override
    public void makeMove(Game game) {
        printMoveInfo(game.ip);
        if (mana >= 10) {
            game.ip.print("Heal: " + this.weapon.getHeal());
            game.ip.print("Enter 0 to hit or 1 to heal");
            this.mana -= 25;
            if (game.ip.getInteger() == 0) {
                hit(game);
            } else {
                game.choseHero().heal();
            }
        }
    }

    @Override
    public void printMoveInfo(InputParser ip) {
        ip.print("Player " + this.name + " make move");
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ip.print("Mana points: " + this.mana);
        ip.print("Your weapon: " + weapon.toString() + ". Damage: " + (this.damage + weapon.getPlusDamage()));
        ip.print("Your armor: " + this.armor + ". " +
                "State: " + this.armor.getState() + "%. " +
                "Protection: " + (int) (100 - this.armor.getDamagePart() * 100) + "%");
    }

}
