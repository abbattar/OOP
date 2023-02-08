package Heroes;

import BatleField.Vector2;

import java.util.List;

public class Farmer extends BaseHero {
    public boolean supply;

    public Farmer(String name, List<BaseHero> gang, int x, int y) {
        super(gang, name, "Колхозник", 1, 1, new int[] {1, 1}, 1, 3, new Vector2(1, 1));
        supply = true;
        super.gang = gang;
        super.position = new Vector2(x, y);
    }

    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d\t", attack, defence, health, (damage[0] + damage[1]) / 2);
        return outStr;
    }

    @Override
    public String toString() {
        return "Колхозник" + "\t" + super.getInfo();
    }
}
