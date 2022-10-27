package rpg;

public /*abstract*/ class Enemy extends Combatant {//TODO добавить рядового монсра и босса


    public Enemy(String name) {
        super(name);
        this.sign = "\uD83D\uDC7E";
    }



    @Override
    public void makeMove(Game game) {
        while (true){
            int randomPlayer = (int) Math.round(Math.random() * (game.getPlayersNumber() - 1));
            if(game.combatants.get(randomPlayer).isAlive())
            {
                Hero hero = (Hero) game.combatants.get(randomPlayer);
                System.out.println("Enemy №" + getName() + " hit " + hero.getName());
                game.combatants.get(randomPlayer).beHit(20);
                break;
            }
        }
    }


}
