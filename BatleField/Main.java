import Heroes.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
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
        for (int i = 0; i < namesMap.size(); i++) {
            llPers.add(i, namesMap.get(i));
        }

        public static final int GANG_SIZE = 10;
        public static ArrayList<BaseHero> whiteSide;
        public static ArrayList<BaseHero> darkSide;

        init();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            ConsoleView.view();
            whiteSide.forEach(n -> n.step(darkSide));
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
            switch (new Random().nextInt(4)) {
                case 0:
                    whiteSide.add(new Peasant(whiteSide, x, y++));
                    break;
                case 1:
                    whiteSide.add(new Robber(whiteSide, x, y++));
                    break;
                case 2:
                    whiteSide.add(new Sniper(whiteSide, x, y++));
                    break;
                default:
                    whiteSide.add(new Monk(whiteSide, x, y++));
                    break;
            }
        }

        x = GANG_SIZE;
        y = 1;
        for (int i = 0; i < GANG_SIZE; i++) {

            switch (new Random().nextInt(4)) {
                case 0:
                    darkSide.add(new Peasant(darkSide, x, y++));
                    break;
                case 1:
                    darkSide.add(new Spareman(darkSide, x, y++));
                    break;
                case 2:
                    darkSide.add(new Xbowman(darkSide, x, y++));
                    break;
                default:
                    darkSide.add(new Wizard(darkSide, x, y++));
                    break;
            }
        }
    }

}

    public static ArrayList<BaseHero> getHeroesInfo(List<String> llPers, int quantity, int groupNumber) {

        ArrayList<BaseHero> heroesList = new ArrayList<>();
        int namesListSize = llPers.size();

        for (int i = 0; i < quantity; i++) {
            int t = rnd(4);
            if (groupNumber == 0) {
                switch (t) {
                    case 0 -> heroesList.add(new Farmer(llPers.get(rnd(namesListSize))));
                    case 1 -> heroesList.add(new Mage(llPers.get(rnd(namesListSize))));
                    case 2 -> heroesList.add(new Rogue(llPers.get(rnd(namesListSize))));
                    case 3 -> heroesList.add(new Sniper(llPers.get(rnd(namesListSize))));

                }
            } else {
                switch (t) {
                    case 0 -> heroesList.add(new Farmer(llPers.get(rnd(namesListSize))));
                    case 1 -> heroesList.add(new Crossbowman(llPers.get(rnd(namesListSize))));
                    case 2 -> heroesList.add(new Monk(llPers.get(rnd(namesListSize))));
                    case 3 -> heroesList.add(new Spearman(llPers.get(rnd(namesListSize))));
                }
            }
        }
        /* Д/з 1, доведённое до ума */
        /*
        for (int i = 0; i < quantity; i++) {
            int t = rnd(7) {
                switch (t) {
                    case 0 -> heroesList.add((new Farmer(llPers.get(rnd(namesListSize)))));
                    case 1 -> heroesList.add(new Mage(llPers.get(rnd(namesListSize))));
                    case 2 -> heroesList.add(new Rogue(llPers.get(rnd(namesListSize))));
                    case 3 -> heroesList.add(new Sniper(llPers.get(rnd(namesListSize))));
                    case 4 -> heroesList.add(new Crossbowman(llPers.get(rnd(namesListSize))));
                    case 5 -> heroesList.add(new Monk(llPers.get(rnd(namesListSize))));
                    case 6 -> heroesList.add(new Spearman(llPers.get(rnd(namesListSize))));
                }
            }
        }
        */
        return heroesList;
    }

    private static int rnd(int upperRange) {
        Random random = new Random();
        return random.nextInt(upperRange);
    }

    private static void choiceHero(ArrayList<BaseHero> heroesList, String heroRole) {
        System.out.printf("Список типов %s героев\n", heroRole);
        for (BaseHero hero : heroesList) {
            if (hero.toString().contains(heroRole)) {
                System.out.println(hero);
            }
        }
    }
}

