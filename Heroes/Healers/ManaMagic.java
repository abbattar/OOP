package Heroes.Healers;

import BatleField.Vector2;
import Heroes.BaseHero;

import java.util.List;

public abstract class ManaMagic extends BaseHero {
    protected int mana;
    public ManaMagic(List<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                     int speed, int mana, Vector2 position) {
        super(gang, name, role, attack, defence, damage, health, speed, position);
        this.mana = mana;
    }

    @Override
    public String toString() {
        return super.toString() + ", Мана: " + mana;
    }
}
