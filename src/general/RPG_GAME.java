package general;

import game.*;

public class RPG_GAME {
    private static int round = 0;

    public static void start() {
        Boss boss = new Boss(2000, 50);

        Mage mage = new Mage(250, 25, "Mage");
        Golem golem = new Golem(400, 15, "Golem");
        Warrior warrior = new Warrior(250, 25, "Warrior");
        Medic medic = new Medic(300, 0, "Medic");
        Berserk berserk = new Berserk(250, 20, "Berserk");

        Hero[] heroes = {mage, golem, warrior, medic, berserk};
        printStatistics(boss, heroes);

        while (!isGameOver(boss, heroes)) {
            round++;
            round(boss, heroes);
        }

    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        boolean allHeroesDead = true;
        if (boss.getHealth() <= 0) {
            System.out.println("Congratulations you won");
            return true;
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
            if (allHeroesDead) {
                System.out.println("Boss WIN!!!");
                break;
            }
        }
        return allHeroesDead;
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("Statistics");
        System.out.println("Boss health: " + "SkeletonKing " + boss.getHealth() + " Boss damage:" + boss.getDamage());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println("Hero health: " + heroes[i].getName() + " " + heroes[i].getHealth() + " Hero damage " + heroes[i].getDamage());
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        System.out.println("ROUND - " + round);
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
        heroesHits(boss, heroes);
        for (Hero hero : heroes) {
            hero.apllySuperAbility(boss, heroes);
        }
        printStatistics(boss, heroes);
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
        if(boss.getHealth() < 0){
            boss.setHealth(0);
        }
    }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
            if(heroes[i].getHealth() <0){
                heroes[i].setHealth(0);
            }
        }
    }

    public static void isAllAlive(Boss boss, Hero[] heroes) {
        for (int i = 0; i <heroes.length; i++) {

        while (
        (boss.isAlive() && (heroes[i].isAlive() || heroes[i].isAlive()))) {
            if (heroes[i].isAlive()) {
                heroesHits(boss, heroes);
            }
            if (boss.isAlive()) {
                bossHits(boss, heroes);
            }
        }
    }
}
}