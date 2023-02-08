package Heroes.Healers;

import BatleField.Vector2;
import Heroes.BaseHero;
import Heroes.Healers.Healer;

import java.util.List;

public class Monk extends Healer {
    public Monk(String name, List<BaseHero> gang, int x, int y){
        super(gang, name, "Монах",12, 7, new int[] {0, 0}/* Пока без возможности атаки */,
                30, 5, 1, new int[]{4, 4}, new Vector2(x,y));
    }
    @Override
    public String getInfo() {
        return String.format("† %d\t\uD83D\uDEE1 %d\t♥%.1f\t☠%d", heal[1],defence,health,(damage[0] + damage[1]) / 2);
    }
}
