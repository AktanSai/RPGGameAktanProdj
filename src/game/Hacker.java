package game;

import java.util.Random;

public class Hacker extends Hero{
    private int healthStolenPerRound;
    private Random random;
    public Hacker(int health, int damage, String name) {
        super(health, damage, SuperAbility.HealthSteal, name);
        this.healthStolenPerRound = healthStolenPerRound;
        this.random = new Random();
    }
    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        int stolenHealth = Math.min(boss.getHealth(), healthStolenPerRound);
        boss.decreaseHealth(stolenHealth);

        int recipientIndex = random.nextInt(heroes.length);
        Hero recipient = heroes[recipientIndex];

        int coefForHero = random.nextInt(9) * 5;
        recipient.increaseHealth(coefForHero);
        if (coefForHero > 0) {
            System.out.println(getName() + " украл " + coefForHero + " здоровья у " + boss.getName() + " и передал " + recipient.getName());
        }
        if(coefForHero == 0){
            System.out.println(getName() + "Ничего не украл, бедолага");
        }
    }
}
