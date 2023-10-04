package game;

public class Witcher extends Hero{

    public Witcher(int health, int damage, String name) {
        super(health, damage, SuperAbility.GiveLife, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            for (Hero hero : heroes) {
                if (hero.getHealth() <= 0) {
                    System.out.println(this.getName() + " оживил первого погибшего героя.");
                    hero.setHealth(this.getHealth());
                    this.setHealth(0);
                    return;
                }
            }
        }
    }
}
