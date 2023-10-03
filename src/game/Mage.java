package game;

import java.util.Random;

public class Mage extends Hero{
    public Mage(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        if(this.getHealth() > 0 ){
            Random random = new Random();
            int coef = random.nextInt(3) + 1;
            for (int i = 0; i < heroes.length; i++) {
            heroes[i].setDamage(coef + heroes[i].getDamage());
        }
            System.out.println(this.getName() + " увеличил всем урона на " + coef );

        }
    }
}
