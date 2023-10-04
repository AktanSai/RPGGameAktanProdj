package game;

import java.util.Random;

public class Druid extends Hero{
    private int assistantBoost;
   private Random random;
    public void setAssistantBoost(int assistantBoost) {
        this.assistantBoost = assistantBoost;
    }
    public Druid(int health, int damage, String name) {
        super(health, damage, SuperAbility.Summon, name);
        assistantBoost = 0;
        random = new Random();
    }

    @Override
    public void apllySuperAbility(Boss boss, Hero[] heroes) {
        int randomNumber = random.nextInt(2);
        if (randomNumber == 0) {
            if(boss.getHealth() < boss.getMaxHealth() * 0.5)
            {boss.setDamage(boss.getDamage() * 3/2);}
            summonRavenAssistant(heroes);
        } else {
            int randomHeroIndex = random.nextInt(heroes.length);
            Hero randomHero = heroes[randomHeroIndex];
            summonAllyClone(randomHero);
        }
    }
    private void summonRavenAssistant(Hero[] heroes) {
        RavenAssistant ravenAssistant = new RavenAssistant(40, 0,"Ворон");
        System.out.println("Друид призывает помощника \"Ворон\".");
        for (Hero hero : heroes) {
            if (hero instanceof Medic) {
                ((Medic) hero).addAssistant(ravenAssistant);
            }
        }
    }

    private Hero summonAllyClone(Hero ally) {
        Hero clonedHero = null;

        if (ally instanceof Boss) {
            Boss originalBoss = (Boss) ally;
            Boss clonedBoss = new Boss(originalBoss.getHealth(), originalBoss.getDamage(), " Clone");
            clonedBoss.setAggressive(originalBoss.getHealth() < 50);
            clonedHero = clonedBoss;
            System.out.println("Друид создает копию босса: " + clonedBoss.getName());
        } else if (ally instanceof Golem) {
            Golem originalHero = (Golem) ally;
            clonedHero = new Golem(originalHero.getHealth(), originalHero.getDamage(),originalHero.getName() + " Clone");
            System.out.println("Друид создает копию Golem: " + clonedHero.getName());
        } else if (ally instanceof Witcher) {
            Witcher originalHero = (Witcher) ally;
            clonedHero = new Witcher(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Witcher: " + clonedHero.getName());
        }  else if (ally instanceof Warrior) {
            Warrior originalHero = (Warrior) ally;
            clonedHero = new Warrior(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Warrior: " + clonedHero.getName());
            
        } else if (ally instanceof Medic) {
            Medic originalHero = (Medic) ally;
            clonedHero = new Medic(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Medic: " + clonedHero.getName());

        }else if (ally instanceof Mage) {
            Mage originalHero = (Mage) ally;
            clonedHero = new Mage(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Mage: " + clonedHero.getName());

        }else if (ally instanceof Berserk) {
            Berserk originalHero = (Berserk) ally;
            clonedHero = new Berserk(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Berserk: " + clonedHero.getName());

        }else if (ally instanceof Thor) {
            Thor originalHero = (Thor) ally;
            clonedHero = new Thor(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Thor: " + clonedHero.getName());

        }else if (ally instanceof Avrora) {
            Avrora originalHero = (Avrora) ally;
            clonedHero = new Avrora(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Avrora: " + clonedHero.getName());

        }else if (ally instanceof Hacker) {
            Hacker originalHero = (Hacker) ally;
            clonedHero = new Hacker(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Hacker: " + clonedHero.getName());

        }else if (ally instanceof TrickyBastard) {
            TrickyBastard originalHero = (TrickyBastard) ally;
            clonedHero = new TrickyBastard(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию TrickyBastard: " + clonedHero.getName());

        }else if (ally instanceof Antman) {
            Antman originalHero = (Antman) ally;
            clonedHero = new Antman(originalHero.getHealth(), originalHero.getDamage(), originalHero.getName() + " Clone");

            System.out.println("Друид создает копию Antman: " + clonedHero.getName());

        }
        return clonedHero;
    }

}
