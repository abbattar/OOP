package Heroes;

public class Farmer extends BaseHero {
    protected int supply;

    public Farmer(String name, String role, int attack, int defence,
                  int[] damage, int health, int speed, boolean isEnemy, int supply) {
        super(name, role, attack, defence, damage, health, speed, isEnemy);
        this.supply = supply;
    }

    public Farmer(String name) {
        super(name, "Колхозник", 1, 1, new int[] {1, 1}, 1, 3, false);
        this.supply = 1;
    }

    public String getInfo() {
        return name + " " + role + " ОЗ.: " + health * 100 / maxHealth + " % [ " + maxHealth
                    + " ]" + " Свободен: " + supply;
    }

    @Override
    public String toString() {
        return super.toString() + ", Поддержка: " + supply;
    }
}
