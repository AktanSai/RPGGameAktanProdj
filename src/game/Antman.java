package game;

import java.util.Random;

public class Antman extends Hero{
    private Random random;

    public Antman(int health, int damage, String name) {
        super(health, damage, SuperAbility.GrowUP, name);
        this.random = new Random();
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            this.setHealth(this.getHealth() / 2);
            this.setDamage(this.getDamage() / 2);
            System.out.println(getName() + " уменьшился в 2 раза.");
        } else {
            this.setHealth(this.getHealth() * 2);
            this.setDamage( this.getDamage() * 2);
            System.out.println(getName() + " увеличился в 2 раза.");
        }
    }
}
