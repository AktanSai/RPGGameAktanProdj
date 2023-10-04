package game;

public class Thor extends Hero {
    public Thor(int health, int damage, String name) {
        super(health, damage, SuperAbility.Stun, name);
    }


    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        boolean bossStunned = false;
        if (this.getHealth() > 0) {
            double chanceToStun = 0.3;
            if (Math.random() < chanceToStun) {
                bossStunned = true;
                System.out.println("Thor оглушил босса на 1 раунд!");
            }
        }
        if (!bossStunned) {
            boss.setDamage(50);
            System.out.println("Thor не оглушил босса и босс нанес урон в этом раунде.");

        } else {
            boss.setDamage(0);


            System.out.println("Thor оглушил босса и босс не нанесет урон в следующем раунде.");
            bossStunned = false;
        }
    }
}