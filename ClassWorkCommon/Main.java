package ClassWorkCommon;

import java.util.Random;

public class Main {
//    public String[] surname = new String[]{"Алексеева", "Беглов", "Иванищев", "Костромской", "Сидоров", "Щербинский"};
//    public String[] name = new String[]{"Аня", "Марик", "Виктор", "Геннадий", "Иван", "Роман"};
//    public String[] unitType = new String[]{"crossbowman", "thug", "farmer", "wizard", "monk", "pikeman", "sniper"};
//
    public static void main(String[] args) {
//        for (int i = 0; i < Name.values().length; i++) {
//            System.out.println(Name.values()[i].name());
//            System.out.println(Name.values()[i].getDiff());
//            System.out.println(Name.values()[i].getAge());
//        }
//    Fam fam = new Fam();
//    fam.getName();

        Fext fam = new Fext();
        randomNames();
    }
    private static Name randomNames() {
        int i = new Random().nextInt(Name.values().length);
        return Name.values()[i];
    }
}
