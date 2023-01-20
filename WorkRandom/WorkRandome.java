package WorkRandom;

import java.util.Random;

public class WorkRandome {
    public static void main(String[] args) {
        System.out.println(generateRandomInt(50));
    }
    private static int generateRandomInt(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}
