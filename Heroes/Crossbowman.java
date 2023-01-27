package Heroes;

import Heroes.Archer;

public class Crossbowman extends Archer {
    public Crossbowman(String name) {
        super(name, "Арбалетчик", 6, 3,
                new int[]{8, 10}, 15, 9, 16, false);
    }
}
