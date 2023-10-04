package game;

public abstract class Hero extends GameEntity implements HavingSuperAbility{
    private SuperAbility superAbility;
    private String name;

    public Hero(int health, int damage, SuperAbility superAbility, String name) {
        super(health, damage, name);
        this.superAbility = superAbility;
        this.name = name;
    }
    public void increaseHealth(int amount) {
        if (amount > 0) {
            setHealth(getHealth() + amount);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
