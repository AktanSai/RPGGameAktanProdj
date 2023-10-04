package general;

import game.*;

public class RPG_GAME {
    private static int round = 0;

    public static void start() {
        Boss boss = new Boss(3000, 50, "SkeletonKing");

        Mage mage = new Mage(250, 25, "Mage");
        Golem golem = new Golem(500, 15, "Golem");
        Warrior warrior = new Warrior(250, 25, "Warrior");
        Medic medic = new Medic(110, 0, "Medic");
        Berserk berserk = new Berserk(210, 20, "Berserk");
        Thor thor = new Thor(300, 20, "Thor");
        Witcher witcher = new Witcher(600, 0, "Witcher");
        Avrora avrora = new Avrora(300, 15, "Avrora");
        Druid druid = new Druid(300,10, "Druid");
        Hacker hacker = new Hacker(350, 10, "Hacker");
        TrickyBastard trickyBastard = new TrickyBastard(300, 10, "TrickyBastard");
        Antman antman = new Antman(400, 15, "Antman");


        Hero[] heroes = {mage, golem, warrior, medic, berserk, thor, witcher, avrora, druid, hacker, trickyBastard, antman};
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
        for (Hero hero : heroes) {
            if (hero instanceof Avrora) {
                Avrora avrora = (Avrora) hero;
                avrora.endRound(); // Вызываем метод endRound() для Avrora
            }
        }
        if (boss.getHealth() > 0) {
            bossHits(boss, heroes);
        }
            heroesHits(boss, heroes);
            printStatistics(boss, heroes);

        }


        private static void bossHits(Boss boss, Hero[] heroes) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
            }
        }

    private static void heroesHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0 && heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
                heroes[i].apllySuperAbility(boss,heroes);
            }
            if(heroes[i].getHealth() <0){
                heroes[i].setHealth(0);
            }
            if(boss.getHealth() < 0){
                boss.setHealth(0);
            }
        }
    }
}