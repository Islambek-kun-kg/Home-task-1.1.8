package kg.geektech.game.players.heroes;
import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;
import java.util.Random;

public class Berserk extends Hero {


    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperPower.BLOCK_AND_ATTACK, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random b = new Random();
        int block = b.nextInt(10) + 5;
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            boss.setHealth(boss.getHealth() - block);
            this.setHealth(this.getHealth() + block);
            System.out.println(this.getName() + " blocked " + block + " damage and added to his damage!");
        }
    }
}
