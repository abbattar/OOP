package Heroes.Melee;

import BatleField.Vector2;
import Heroes.BaseHero;

import java.util.List;

public class Spearman extends BaseHero {
    public Spearman(String name, List<BaseHero> gang, int x, int y){
        super(gang, name, "Копейщик", 4, 5,
                new int[] {1, 3}, 4, 10, new Vector2(x, y));
    }
    @Override
    public String getInfo() {
        return String.format("† %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d\f", attack,defence,health,(damage[0] + damage[1]) / 2);
    }
}
