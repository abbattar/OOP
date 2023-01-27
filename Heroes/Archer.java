package Heroes;

import java.util.ArrayList;

public abstract class Archer extends BaseHero {
    protected int shoots;

    public Archer(String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int shoots, boolean isEnemy) {
        super(name, role, attack, defence, damage, health, speed, isEnemy);
        this.shoots = shoots;
    }

    @Override
    public String toString() {
        return super.toString() + ", Выстрелы: " + shoots;
    }
    @Override
    public String getInfo() {
        return name + " " + role + " ОЗ.: " + health * 100 / maxHealth + " % [ " + maxHealth
                + " ]" + " Стрел в колчане: " + shoots;
    }
    @Override
    public void step(ArrayList<BaseHero> heroList) {
        for (int i = 0; i < heroList.size(); i++) {
            String[] params = heroList.get(i).getInfo().split(" ");
            if (params[2] == "Колхозник") {
                if (((Farmer)heroList.get(i)).supply > 0) {
                    ((Farmer)heroList.get(i)).supply = 0;
                    System.out.printf("\n%s %s стреляет ", role, name);
                    System.out.println("\nЕщё стрел: " + shoots);
                    return;
                } else {
                    ((Farmer)heroList.get(i)).supply = 1;
                    break;
                }
            } else {
                shoots --;
                System.out.printf("\n%s %s стреляет ", role, name);
                System.out.println("\nЕщё стрел: " + shoots);
            }
        }
    }
}
