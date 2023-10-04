package game;

public class Boss extends Hero{

    private int maxHealth;
    public Boss(int health, int damage, String name) {
        super(health, damage,SuperAbility.Stun, name);
        maxHealth = health;
    }
    public void setAggressive(boolean isAggressive) {
    }
    public String getName() {
        return super.getName();
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    public void decreaseHealth(int amount) {
        if (amount > 0) {
            setHealth(getHealth() - amount);
            if (getHealth() < 0) {
                setHealth(0);
            }
        }
    }
    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {

    }
}
