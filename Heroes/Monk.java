package Heroes;

public class Monk extends Healer {
    public Monk(String name){
        super(name, "Монах",12, 7, new int[] {0, 0}/* Пока без возможности атаи */,
                30, 5, false, 1, new int[]{4, 4});
    }
}
