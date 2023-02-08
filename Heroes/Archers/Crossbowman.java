package Heroes.Archers;

import BatleField.Vector2;
import Heroes.Archers.Archer;
import Heroes.BaseHero;

import java.util.List;

public class Crossbowman extends Archer {
    public Crossbowman(String name, List<BaseHero> gang, int x, int y) {
        super(gang, name, "Арбалетчик", 6, 3,
                new int[]{8, 10}, 15, 9, 16, 16,new Vector2(x,y));
    }
    @Override
    public String getInfo() {
        String outStr = String.format("⚔ %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d", attack,defence,health,(damage[0] + damage[1])/2,speed);
        return outStr;
    }
}
