package game;

public class Avrora extends Hero {
    private int roundsInvisible;
    public Avrora(int health, int damage, String name) {
        super(health, damage, SuperAbility.Invisibility, name);
        roundsInvisible = 3;
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        if (roundsInvisible == 0) {
            roundsInvisible = 3;
            this.setDamage(boss.getDamage() * 2);
            System.out.println("Avrora возвращает " + boss.getDamage() * 2 + " урона боссу.");
        } else {
            this.setDamage(0);
            System.out.println("Avrora входит в режим невидимости на 2 раунда.");

        }
    }
    public void endRound() {
        if (roundsInvisible > 0) {
            roundsInvisible--;
        }
    }

}
