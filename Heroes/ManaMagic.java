package Heroes;

import java.util.ArrayList;

public abstract class ManaMagic extends BaseHero {
    protected int mana;
    public ManaMagic(String name, String role, int attack, int defence,
                     int[] damage, int health, int speed, boolean isEnemy, int mana) {
        super(name, role, attack, defence, damage, health, speed, isEnemy);
        this.mana = mana;
    }
    @Override
    public String toString() {
        return super.toString() + ", Мана: " + mana;
    }
}
