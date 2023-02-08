package BatleField;


/*import java.util.Collections;

public class ConsoleView {
    private static int step = 1;
    //----------------отрисовка строчек псевдографики таблицы ---------начало ----------------
    private static final String top10 = formateDiv("a") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-b"))) + formateDiv("-c");
    private static final String mid10 = formateDiv("d") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-e"))) + formateDiv("-f");
    private static final String bott10 = formateDiv("g") + String.join("",
            Collections.nCopies(Main.GANG_SIZE - 1,formateDiv("-h"))) + formateDiv("-i");

    //----------------отрисовка строчек псевдографики таблицы --------конец-----------------
    public static void view(){

        if (ConsoleView.step == 1 ){
            System.out.println(ANSIColors.ANSI_GREEN + "First step" + ANSIColors.ANSI_RESET);
        } else {
            System.out.println("Step " + step + ".");
        }
        step++;

        System.out.println(ConsoleView.top10);

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getHeroChar(new Vector2(j, i)));
            }
            System.out.println();
            System.out.println(ConsoleView.mid10);
        }
        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getHeroChar(new Vector2(j, Main.GANG_SIZE)));
        }
//        System.out.println("|");
        System.out.println();
        System.out.println(ConsoleView.bott10);
        System.out.println("Press Enter");


    }

    private static String formateDiv(String str){
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500');
    }
    private static String getHeroChar(Vector2 position){
        String str = "| ";
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.darkSide.get(i).getPosition().isEquals(position)) {
                str = "|" + ANSIColors.ANSI_BLUE + Main.darkSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET + "|"
                        + " ".repeat(3) + ANSIColors.ANSI_GREEN + Main.whiteSide.get(i).getInfo() + ANSIColors.ANSI_RESET
                        + " ".repeat(5) + ANSIColors.ANSI_BLUE + Main.darkSide.get(i).getInfo() + ANSIColors.ANSI_RESET;
            }

            if (Main.whiteSide.get(i).getPosition().isEquals(position)){
                str = "|" + ANSIColors.ANSI_GREEN + Main.whiteSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET;
            }
        }
        return str;
    }
}

 */
import java.util.Collections;

public class ConsoleView {
    public static int step = 0;
    private static final String top10 = formatDiv("a") + String.join("", Collections.nCopies(9, formatDiv("-b"))) + formatDiv("-c");
    private static final String mid10 = formatDiv("d") + String.join("", Collections.nCopies(9, formatDiv("-e"))) + formatDiv("-f");
    private static final String bottom10 = formatDiv("g") + String.join("", Collections.nCopies(9, formatDiv("-h"))) + formatDiv("-i");

    public static void view() {
        if (step++ == 0) {
            System.out.print(ANSIColors.ANSI_RED + "First step!" + ANSIColors.ANSI_RESET);
            System.out.print(ANSIColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Blue Team" + ANSIColors.ANSI_RESET);
            System.out.println(ANSIColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Green Team" + ANSIColors.ANSI_RESET);
        } else {
            System.out.print(ANSIColors.ANSI_RED + "Step: " + step + ANSIColors.ANSI_RESET);
            System.out.print(ANSIColors.ANSI_BLUE +
                    String.join("", Collections.nCopies(20, formatDiv(" "))) + "Blue Team" + ANSIColors.ANSI_RESET);
            System.out.println(ANSIColors.ANSI_GREEN +
                    String.join("", Collections.nCopies(40, formatDiv(" "))) + "Green Team" + ANSIColors.ANSI_RESET);
        }

        System.out.println(ConsoleView.top10);

        int npcIndex = 0;

        for (int i = 1; i <= Main.GANG_SIZE - 1; i++) {
            for (int j = 1; j <= Main.GANG_SIZE; j++) {
                System.out.print(getChar(new Vector2(j, i)));
            }
            System.out.print("|");
            System.out.println(PrintInfo(npcIndex));
            System.out.println(ConsoleView.mid10);
            npcIndex++;
        }

        for (int j = 1; j <= Main.GANG_SIZE; j++) {
            System.out.print(getChar(new Vector2(j, Main.GANG_SIZE)));
        }
        System.out.print("|");
        System.out.println(PrintInfo(npcIndex));
        System.out.println(ConsoleView.bottom10);
    }

    private static String getChar(Vector2 position) {

        String str = "| ";
        boolean alive = false;
        for (int i = 0; i < Main.GANG_SIZE; i++) {
            if (Main.whiteSide.get(i).getPosition().isEquals(position)) {
                if (Main.whiteSide.get(i).getHealth() == 0)
                    str = "|" + ANSIColors.ANSI_RED + Main.whiteSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET;
                else {
                    str = "|" + ANSIColors.ANSI_GREEN + Main.whiteSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET;
                    alive = true;
                }
            }
            if (Main.darkSide.get(i).getPosition().isEquals(position) && !alive) {
                if (Main.darkSide.get(i).getHealth() == 0)
                    str = "|" + ANSIColors.ANSI_RED + Main.darkSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET;
                else
                    str = "|" + ANSIColors.ANSI_BLUE + Main.darkSide.get(i).getRole().toUpperCase().charAt(0) + ANSIColors.ANSI_RESET;
            }
        }
        return str;
    }

    private static String PrintInfo(int npcIndex) {
        String str = "";

        if (Main.whiteSide.get(npcIndex).getHealth() == 0)
            str += "     " + ANSIColors.ANSI_RED + Main.whiteSide.get(npcIndex).getInfo() + ANSIColors.ANSI_RESET;
        else str += "     " + ANSIColors.ANSI_BLUE + Main.whiteSide.get(npcIndex).getInfo() + ANSIColors.ANSI_RESET;
        if (Main.darkSide.get(npcIndex).getHealth() == 0)
            str += "     " + ANSIColors.ANSI_RED + Main.darkSide.get(npcIndex).getInfo() + ANSIColors.ANSI_RESET;
        else str += "     " + ANSIColors.ANSI_GREEN + Main.darkSide.get(npcIndex).getInfo() + ANSIColors.ANSI_RESET;

        return str;
    }

    private static String formatDiv(String str) {
        return str.replace('a', '\u250c')
                .replace('b', '\u252c')
                .replace('c', '\u2510')
                .replace('d', '\u251c')
                .replace('e', '\u253c')
                .replace('f', '\u2524')
                .replace('g', '\u2514')
                .replace('h', '\u2534')
                .replace('i', '\u2518')
                .replace('-', '\u2500')
                .replace("s", "...")
                .replace("o", "___");
    }
}
