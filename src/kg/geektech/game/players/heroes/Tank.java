package kg.geektech.game.players.heroes;
import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;

public class Tank extends Hero {
    public Tank(int health, int damage, String name) {
        super(health, damage, SuperPower.BLOCK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                if (this.getHealth() > 0) {
                    heroes[i].setHealth(heroes[i].getHealth() + (boss.getDamage() / 5));

                }
            }
        }
        if (this.getHealth() > 0) {
            System.out.println(this.getName() + " blocked " + boss.getDamage() / 5 + " damage!");
        }
    }
}
