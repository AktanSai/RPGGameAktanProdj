package game;

public class Golem extends Hero {

    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.DAMAGEOFBOSSTOBOSS, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] hero) {
        if (this.getHealth() > 0) {
            for (int i = 0; i < hero.length; i++) {

                int damageToTake = boss.getDamage() / 5;
                setHealth(getHealth() - damageToTake);
                System.out.println(getName() + " принимает " + damageToTake + " урона от босса.");
                break;

            }
            for (int i = 0; i < hero.length; i++) {
                if (hero[i] != this && hero[i].getHealth() > 0) {
                    hero[i].setHealth(boss.getDamage() / 5 + hero[i].getHealth());
                }
            }
        }
    }
}