package Heroes;

public class Mage extends Healer {
    public Mage(String name) {
        super(name, "Колдун", 17, 12,
                new int[]{0, 0}, 30, 9, false, 1, new int[]{5, 5});
    }
}
