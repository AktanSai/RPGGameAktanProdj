package game;

public class Avrora extends Hero{
    public Avrora(int health, int damage, String name) {
        super(health, damage, SuperAbility.Invisibility, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {

    }
}
