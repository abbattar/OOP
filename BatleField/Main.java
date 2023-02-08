package BatleField;

import Heroes.*;
import Heroes.Archers.Crossbowman;
import Heroes.Archers.Sniper;
import Heroes.Healers.Mage;
import Heroes.Healers.Monk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static final int GANG_SIZE = 10;
    public static ArrayList<BaseHero> whiteSide;
    public static ArrayList<BaseHero> darkSide;

    public static void main(String[] args) {

        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            System.out.println("Тёмные");
            whiteSide.forEach(n -> n.step(darkSide));
            System.out.println("Светлые");
            darkSide.forEach(n -> n.step(whiteSide));
            scanner.nextLine();
        }
    }

    private static void init() {
        whiteSide = new ArrayList<>();
        darkSide = new ArrayList<>();

        int x = 1;
        int y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (rnd(4)) {
                case 0 -> whiteSide.add(new Farmer(getNames().get(rnd(getNames().size())), whiteSide, x, y++));
                case 1 -> whiteSide.add(new Rogue(getNames().get(rnd(getNames().size())), whiteSide, x, y++));
                case 2 -> whiteSide.add(new Sniper(getNames().get(rnd(getNames().size())), whiteSide, x, y++));
                case 3 -> whiteSide.add(new Monk(getNames().get(rnd(getNames().size())), whiteSide, x, y++));
            }
        }
        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {
            switch (rnd(4)) {
                case 0 -> darkSide.add(new Farmer(getNames().get(rnd(getNames().size())), darkSide, x, y++));
                case 1 -> darkSide.add(new Spearman(getNames().get(rnd(getNames().size())), darkSide, x, y++));
                case 2 -> darkSide.add(new Crossbowman(getNames().get(rnd(getNames().size())), darkSide, x, y++));
                case 3 -> darkSide.add(new Mage(getNames().get(rnd(getNames().size())), darkSide, x, y++));
            }
        }
    }

    private static int rnd(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    private static List<String> getNames() {
        Map<Integer, String> namesMap = new HashMap<>();

        Path path = Paths.get("BatleField/Names.txt");
        try {
            List<String> ls = Files.readAllLines(path);
            for (int i = 0; i < 50; i++) {
                namesMap.put(i, ls.get(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        List<String> llPers = new LinkedList<>();
        for (int i = 0; i < namesMap.size(); i++) {
            llPers.add(i, namesMap.get(i));
        }
        return llPers;
    }
}

