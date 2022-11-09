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
                    this.mana -= 10;
                    hit(game);
                }
                return;
            case 1:
                eat(game);
                return;
            case 2:
                if(this.mana > 10){
                    this.mana -= 10;
                    game.choseHero().heal();
                }
                return;
            case 0:
                usePotion(game);
        }

    }

    private void usePotion(Game game) {
        game.potions.use();
        this.mana += game.potions.getManaPoints();
        if(this.mana > 100){
            this.mana = 100;
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

    @Override
    public void doAction(Game game) {
        game.ip.print("0 - increase damage(+10), 1 - improve armor(+10%), " +
                "2 - improve food(+10 health), 3 - improve points(+10 mana), 4 - add food, 5 - add points" +
                "6 - increase damage(+10)");
        switch (game.ip.getInteger()){
            case 0:
                increaseDamage(10);//10?
                return;
            case 1:
                improveArmor();
                return;
            case 2:
                game.food.improve();
                return;
            case 3:
                game.potions.improve();
                return;
            case 4:
                game.food.add(3);
                return;
            case 5:
                game.potions.add(3);
        }
    }
}
