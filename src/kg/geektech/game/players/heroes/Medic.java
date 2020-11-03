package kg.geektech.game.players.heroes;

import kg.geektech.game.players.Boss;
import kg.geektech.game.players.SuperPower;

public class Medic extends Hero {
    private int healPoints;

    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, SuperPower.HEAL, name);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        System.out.println(this.getName() + " healing all for " + healPoints + "!");
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] != this && heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() + healPoints);
            }
        }
    }
}
