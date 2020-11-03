package kg.geektech.game.players.heroes;

import kg.geektech.game.players.GameEntity;
import kg.geektech.game.players.HavingSuperPower;
import kg.geektech.game.players.SuperPower;

public abstract class Hero extends GameEntity implements HavingSuperPower {
    private SuperPower superPower;

    public SuperPower getSuperPower() {
        return superPower;
    }

    public void setSuperPower(SuperPower superPower) {
        this.superPower = superPower;
    }

    public Hero(int health, int damage, SuperPower superPower, String name) {
        super(health, damage, name);
        this.superPower = superPower;
    }

}
