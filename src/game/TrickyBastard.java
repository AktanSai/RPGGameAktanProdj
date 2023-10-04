package game;

import java.util.Random;

public class TrickyBastard extends Hero{
    private boolean isDead;
    private Random random;
    public TrickyBastard(int health, int damage,String name) {
        super(health, damage, SuperAbility.IsDEAD, name);
        this.random = new Random();
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        int randomNumber = random.nextInt(2); // Генерируем случайное число 0 или 1

        if (randomNumber == 0) {
            isDead = true;
            System.out.println(getName() + " притворяется мертвым в этом раунде.");
        } else {
            isDead = false;
            System.out.println(getName() + " воскресает и вступает в бой в этом раунде.");
        }
    }
}
