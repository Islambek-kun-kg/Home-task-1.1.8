package kg.geektech.game.players.heroes;

import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;

import java.util.Random;

public class Hacker extends Hero {

    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperPower.HACKING, name);

    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random s = new Random();
        int hacking = s.nextInt(20) + 20;
        Random h = new Random();
        int hack = h.nextInt(2);
        for (int i = 0; i < 100; i++) {
            Random g = new Random();
            int hero = g.nextInt(heroes.length);
            if (this.getHealth() > 0 && boss.getHealth() > 0) {
                if (hack == 1) {
                    if (heroes[hero].getHealth() > 0 && heroes[hero] != this) {
                        boss.setHealth(boss.getHealth() - hacking);
                        heroes[hero].setHealth(heroes[hero].getHealth() + hacking);
                        System.out.println(this.getName() + " Hacking boss and hill teamater " + heroes[hero].getName()
                                + " for " + hacking + "!!!");
                        break;
                    }
                }
            }
        }
    }
}

