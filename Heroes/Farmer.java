public class Farmer extends BaseHero {
    protected int supply;

    public Farmer(String name, String role, int attack, int defence, int[] damage, int health, int speed, int supply) {
        super(name, role, attack, defence, damage, health, speed);
        this.supply = supply;
    }

    public Farmer(String name){
        super(name, "Колхозник", 1, 1, new int[] {1, 1}, 1, 3);
        this.supply = 1;
    }

    @Override
    public String toString() {
        return super.toString() + ", Поддержка: " + supply;
    }
}
