package game;

import java.util.Random;

public class Warrior extends Hero{

    public Warrior(int health, int damage, String name) {
        super(health, damage, SuperAbility.CriticalDamage, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] hero) {
        if (this.getHealth() > 0) {
            Random random = new Random();
            int coef = random.nextInt(3) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * coef);
            System.out.println(this.getName() + " his critically " + coef * this.getDamage());
        }
    }
}
