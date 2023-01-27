import Heroes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Team {
    public static void main(String[] args) {

        Map<Integer, String> namesMap = new HashMap<>();

        Path path = Paths.get("Names.txt");
        try {
            List<String> ls = Files.readAllLines(path);
            for (int i = 0; i < 50; i++) {
                namesMap.put(i, ls.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> llPers = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            llPers.add(i, namesMap.get(i));
        }

        System.out.println(llPers);

        Scanner sc = new Scanner(System.in);
        String persName = new String();
        System.out.println("Назовите имя персонажа: ");   // Любая String
        persName = sc.nextLine();
        sc.close();


        Crossbowman crossbowman = new Crossbowman(persName);
        Farmer farmer = new Farmer(persName);
        Mage mage = new Mage(persName);
        Monk monk = new Monk(persName);
        Rogue rogue = new Rogue(persName);
        Sniper sniper = new Sniper(persName);
        Spearman spearman = new Spearman(persName);

        // System.out.println(namesMap);


        List<Object> heroList = new LinkedList<>();

        for (int i = 0; i < 7; i++) {
            heroList.add(crossbowman = new Crossbowman(namesMap.get(i)));
        }
        for (int i = 7; i < 14; i++) {
            heroList.add(farmer = new Farmer(namesMap.get(i)));
        }
        for (int i = 14; i < 21; i++) {
            heroList.add(mage = new Mage(namesMap.get(i)));
        }
        for (int i = 21; i < 28; i++) {
            heroList.add(monk = new Monk(namesMap.get(i)));
        }
        for (int i = 28; i < 35; i++) {
            heroList.add(rogue = new Rogue(namesMap.get(i)));
        }
        for (int i = 35; i < 42; i++) {
            heroList.add(sniper = new Sniper(namesMap.get(i)));
        }
        for (int i = 42; i < 50; i++) {
            heroList.add(spearman = new Spearman(namesMap.get(i)));
        }
        System.out.println(heroList);
    }

    private static int rnd(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }
}