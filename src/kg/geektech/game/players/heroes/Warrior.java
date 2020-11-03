package kg.geektech.game.players.heroes;
import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;
import java.util.Random;

public class Warrior extends Hero {


    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperPower.CRITICAL_DAMAGE, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random c = new Random();
        int critical = c.nextInt(2) + 2;
        if (this.getHealth() > 0 && boss.getHealth() > 0)
            boss.setHealth(boss.getHealth() + this.getDamage() - (this.getDamage() * critical));
        System.out.println(this.getName() + " attack " + this.getDamage() * critical + " critical damage!");
    }
}

