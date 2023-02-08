package Heroes.Healers;

import BatleField.Vector2;
import Heroes.BaseHero;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Healer extends ManaMagic { // Внук BaseHero
    protected int[] heal;

    public Healer(List<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int mana, int[] heal, Vector2 position) {
        super(gang, name, role, attack, defence, damage, health, speed, mana, position);
        this.heal = heal;
    }

    @Override
    public void step(ArrayList<BaseHero> heroList) {
        if (health == 0) {
            return;
        }
        float minHealth = 100;
        int minIndex = 0;
        for (int i = 0; i < gang.size(); i++) {
            if (gang.get(i).health == 0 || gang.get(i).health == gang.get(i).maxHealth) {
                continue;
            }
            if (getHealth() < minHealth) {
                float tmp = gang.get(i).getHealth();
                if (tmp < minHealth) {
                    minHealth = tmp;
                    minIndex = i;
                }
            }
        }
        if (minHealth < 100) {
            heroList.get(minIndex).health = (float) Healer(heroList.get(minIndex));
        }
        System.out.printf("%s %s лечится от %s %s на величину %d\n", heroList.get(minIndex).getRole(), heroList.get(minIndex).getName(),
                role, name, heal[1]);
    }

    private double Healer(BaseHero hero) {
        if (hero.health == 0) { return 0; }
        if (hero.health < hero.maxHealth) {
            hero.health = hero.health + heal[0];
        }
        return hero.health;
    }

    @Override
    public String toString() {
        return super.toString() + ", Забота: " + Arrays.toString(heal);
    }
}
