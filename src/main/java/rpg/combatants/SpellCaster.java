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

        game.printGameInfo();
        printMoveInfo(game.ip);
        game.ip.print("Heal: " + this.weapon.getHeal());

        game.ip.print("0 - use potion (+50 mana), 1 - eat(+25 health), 2 - heal, 3 - hit");

        int action = game.ip.getInteger();
        switch (action) {
            case 3:
                if(this.mana > 10){
                    hit(game);
                }
                return;
            case 1:
                eat(game);
                return;
            case 2:
                game.choseHero().heal();
                return;
            case 0:
                usePotion(game);
        }

    }

    private void usePotion(Game game) {
        game.potions.use();
        this.mana += 50;
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
