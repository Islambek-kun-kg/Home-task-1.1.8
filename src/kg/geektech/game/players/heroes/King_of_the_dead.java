package kg.geektech.game.players.heroes;

import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;

import java.util.Random;

public class King_of_the_dead extends Hero {
    public King_of_the_dead(int health, int damage, String name) {
        super(health, damage, SuperPower.DEAD, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random d = new Random();
        int dead = d.nextInt(100);
        if (this.getHealth() > 0 && boss.getHealth() > 0) {
            if (dead == 93) {
                boss.setHealth(0);
                System.out.println(this.getName() + " use your super power and boss died!!!");
            }
        }
    }
}
