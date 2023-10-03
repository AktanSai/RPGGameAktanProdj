package game;

public class Berserk extends Hero {

    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.CounterAttack, name);
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] hero) {
       if(this.getHealth() > 0){
           for (int i = 0; i < hero.length; i++) {

               int damageToAttack = boss.getDamage() / 6;
               boss.setHealth(boss.getHealth() - damageToAttack);
               System.out.println(getName() + " наносит " + damageToAttack + " урона от босса.");
               break;
           }
           }
        }
    }
