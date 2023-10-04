package game;

public class Boss extends Hero{
    private boolean isAggressive;
    private int maxHealth;
    public Boss(int health, int damage, String name) {
        super(health, damage,SuperAbility.Stun, name);
        isAggressive = false;
        maxHealth = health;

    }
    public void setAggressive(boolean isAggressive) {
        this.isAggressive = isAggressive;
    }
    public String getName() {
        return super.getName();
    }
    public int getMaxHealth() {
        return maxHealth;
    }
    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {

    }
}
