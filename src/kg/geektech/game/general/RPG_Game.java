package kg.geektech.game.general;

import kg.geektech.game.players.*;
import kg.geektech.game.players.heroes.*;

public class RPG_Game {

    public static void start() {
        System.out.println("Game started!!!");
        Boss boss = new Boss(2000, 50, "Kaguya");
        Warrior warrior = new Warrior(250, 20, "Uchiha Sasuke");
        Medic doc = new Medic(235, 0, 15, "Tsunade Grand");
        Magic magic = new Magic(240, 15, "Gaara Kage");
        Berserk berserk = new Berserk(250, 10, "Uzumaki Naruto");
        Medic assistant = new Medic(230, 5, 5, "Haruno Sakura");
        Witcher witcher = new Witcher(300, 0, "Pain Cool");
        Tank tank = new Tank(300, 10, "Maito Gai");
        Hacker hacker = new Hacker(220, 10, "Shikamaru Nara");
        King_of_the_dead king_of_the_dead = new King_of_the_dead(250, 10, "Oturan Wan Di Lir");
        Hero[] heroes = {warrior, doc, magic, berserk, assistant, witcher, tank, hacker, king_of_the_dead};
        printStatistics(boss, heroes);
        while (!isGameFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        heroesHit(boss, heroes);
        if (boss.getHealth() > 0) {
            bossHit(boss, heroes);
        }
        heroesApplySuperPower(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {

            if (heroes[i].getHealth() > 0)
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
        }
    }

    private static void heroesApplySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 && boss.getHealth() > 0)
                heroes[i].applySuperPower(boss, heroes);
        }
    }

    private static boolean isGameFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Heroes lose!!!");
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("-----------");
        System.out.println(boss.getName() + " health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getName() + " health: " + heroes[i].getHealth());
        }
        System.out.println("-----------");
    }

}
