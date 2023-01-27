package Heroes;

import java.util.ArrayList;
import java.util.Arrays;

public class Healer extends ManaMagic { // Внук BaseHero
    protected int[] heal;

    public Healer(String name, String role, int attack, int defence, int[] damage /* Может атаковать  */,
                  int health, int speed, boolean isEnemy, int mana, int[] heal) {
        super(name, role, attack, defence, damage, health, speed, isEnemy, mana);
        this.heal = heal;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        int minHealth = 100;
        int minIndex = 0;
        for (int i = 0; i < heroList.size(); i++) {
            String[] params = heroList.get(i).getInfo().split(" ");
            if (Integer.parseInt(params[3]) < minHealth) {
                int tmp = Integer.parseInt(params[3]);
                if (tmp < minHealth) {
                    minHealth = tmp;
                    minIndex = i;
                }
            }
        }
        heroList.get(minIndex).health = Healer(heroList.get(minIndex));
        System.out.println("\nЛечба прошла на герое:\n" + heroList.get(minIndex));
    }

    private int Healer(BaseHero hero) {
        if (hero.health == 0) { return 0; }
        if (hero.health < hero.maxHealth) {
            hero.health = hero.health + heal[0];
        }
        return hero.health;
    }
    //double max = Collections.max(reduce);


    @Override
    public String toString() {
        return super.toString() + ", Забота: " + Arrays.toString(heal);
    }
}
