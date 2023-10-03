package game;

public class Medic extends Hero implements HavingSuperAbility {
    public Medic(int health, int damage, String name) {
        super(health, damage, SuperAbility.Heal, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        if (this.getHealth() > 0) {
            int medicHeal = 50;
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() < 100 && heroes[i].getHealth() > 0 && this.isAlive()) {
                    heroes[i].setHealth(heroes[i].getHealth() + medicHeal);
                    System.out.println("Medic heals - " + heroes[i].getName());
                    break;
                }
            }
        }
        if(this.getDamage() > 0){
            setDamage(0);
        }
    }
}