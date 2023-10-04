package game;

public class RavenAssistant extends Druid{
    private int medicBoost;

    public RavenAssistant(int health, int damage, String name) {
        super(health, damage, name);
        medicBoost = 0;
    }
    public void setMedicBoost(int medicBoost) {
        this.medicBoost = medicBoost;
    }
}
