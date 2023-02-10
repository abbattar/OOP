package Heroes.Melee;

import BatleField.Vector2;
import Heroes.BaseHero;

import java.util.List;

public class Rogue extends BaseHero {
    public Rogue(String name, List<BaseHero> gang, int x, int y){
        super(gang, name, "Разбойник", 8, 3, new int[] {2, 4}, 10, 6, new Vector2(x,y));
    }
    @Override
    public String getInfo() {
        return String.format("† %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d\f", attack,defence,health,(damage[0] + damage[1]) / 2);
    }
}
