package Heroes.Archers;

import BatleField.Vector2;
import Heroes.Archers.Archer;
import Heroes.BaseHero;

import java.util.List;

public class Sniper extends Archer {
    public Sniper(String name, List<BaseHero> gang, int x, int y) {
        super(gang, name, "Снайпер", 12, 10,
                new int[]{8, 10}, 15, 9, 32, 32, new Vector2(x,y));
    }
    @Override
    public String getInfo() {
        return String.format("† %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d\f", shoots,defence,health,(damage[0] + damage[1]) / 2);
    }
}
