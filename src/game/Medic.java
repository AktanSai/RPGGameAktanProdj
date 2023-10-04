package game;

public class Medic extends Hero implements HavingSuperAbility {
    public Medic(int health, int damage, String name) {
        super(health, damage, SuperAbility.Heal, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        boolean medicAlive = true;
        if (this.getHealth() > 0) {
            int medicHeal = 50;

            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getName().equals("Medic"))  {
                    medicAlive = true;
                    break;
                }
            }

            for (int i = 0; i < heroes.length; i++) {
                    if (heroes[i].getHealth() < 100 && heroes[i].getHealth() > 0 && !heroes[i].equals(this) && medicAlive) {
                        heroes[i].setHealth(heroes[i].getHealth() + medicHeal);
                        System.out.println("Медик вылечил, слава ему! - " + heroes[i].getName());
                        break;
                    }
                }


        }
            if (this.getDamage() > 0) {
                setDamage(0);
            }
        if(this.getHealth() <= 0){
            medicAlive = false;
            if(this.getHealth() > 0){
                this.setHealth(0);
            }
        }
        if(!medicAlive){
            System.out.println("Медик мертв, некому лечить.");
        }
        }
    }