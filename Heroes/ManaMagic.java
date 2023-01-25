package Heroes;

import Heroes.BaseHero;

public abstract class Magics extends BaseHero {
    protected int mana;
    public Magics(String name, String role, int attack, int defence, int[] damage, int health, int speed, int mana) {
        super(name, role, attack, defence, damage, health, speed);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Мана: " + mana;
    }
}
