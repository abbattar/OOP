package Heroes.Healers;

import BatleField.Vector2;
import Heroes.BaseHero;
import Heroes.Healers.Healer;

import java.util.List;

public class Mage extends Healer {
    public Mage(String name, List<BaseHero> gang, int x, int y) {
        super(gang, name, "Колдун", 17, 12,
                new int[]{0, 0}, 30, 9, 1, new int[]{5, 5}, new Vector2(1,1));
    }
    @Override
    public String getInfo() {
        return String.format("† %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d\f", heal[1],defence,health,(damage[0] + damage[1]) / 2);
    }
}
