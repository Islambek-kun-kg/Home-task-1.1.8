package kg.geektech.game.players.heroes;

import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;

import java.util.Random;

public class Magic extends Hero {


    public Magic(int health, int damage, String name) {
        super(health, damage, SuperPower.ATTACK_UP, name);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random a = new Random();
        int attack = a.nextInt(5) + 5;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0 && heroes[i].getDamage() > 0)
                if (this.getHealth() > 0) {
                    boss.setHealth(boss.getHealth() - attack);
                }
        }
        if (this.getHealth() > 0) {
            System.out.println(this.getName() + " increases " + attack + " damage to all living heroes!");
        }
    }
}