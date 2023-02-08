package Heroes.Archers;

import BatleField.Vector2;
import Heroes.BaseHero;
import Heroes.Farmer;

import java.util.ArrayList;
import java.util.List;

public abstract class Archer extends BaseHero {
    protected int maxShoots;
    protected int shoots;

    public Archer(List<BaseHero> gang, String name, String role, int attack, int defence, int[] damage, int health,
                  int speed, int shoots, int maxShoots, Vector2 position) {
        super(gang, name, role, attack, defence, damage, health, speed, position);
        this.shoots = shoots;
        this.maxShoots = shoots;
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
        if (health == 0) {
            return;
        }
        Vector2 target = getTarget(heroList);
        float minDistanceDamage = 12;
        float maxDistanceDamage = 4;
        float attackPower;
        if (target.x <= maxDistanceDamage) {
            attackPower = damage[1];
        } else if (target.x >= 12) {
            attackPower = damage[0];
        } else {
            attackPower = damage[0] + ((target.x - minDistanceDamage) / (minDistanceDamage - maxDistanceDamage)) * (damage[1] - damage[0]);
        }

        boolean doShoots = false;
        for (int i = 0; i < heroList.size(); i++) {
            if (heroList.get(i).getRole().equals("Колхозник")) {
                if (((Farmer) heroList.get(i)).supply) {
                    heroList.get((int) target.y).getDamage(attackPower);
                    System.out.printf("\n%s %s стреляет в персонажа %s %s, наносит %f урона ", role, name, heroList.get((int) target.y).getName(),
                            heroList.get((int) target.y).getRole(), attackPower);
                    System.out.printf("\nКолхозник %s подносит стрелу", heroList.get(i).getName());
                    System.out.printf("\nЕщё стрел: %d / %d\n", shoots, maxShoots);
                    ((Farmer) heroList.get(i)).supply = false;
                    doShoots = true;
                    break;
                }
            }
        }
        if (!doShoots) {
            if (shoots > 0) {
                heroList.get((int) target.y).getDamage(attackPower);
                System.out.printf("\n%s %s стреляет в персонажа %s %s, наносит %f урона ", role, name, heroList.get((int) target.y).getName(),
                        heroList.get((int) target.y).getRole(), attackPower);
                System.out.printf("\nЕщё стрел: %d / %d\n", --shoots, maxShoots);
            } else {
                System.out.printf("\nУ %s %s стрелы закончились", role, name);
            }
        }
    }

    private Vector2 getTarget(ArrayList<BaseHero> heroList) {
        float minDistance = getPosition().getDistance(heroList.get(0).getPosition().x, heroList.get(0).getPosition().y);
        int minIndex = 0;
        for (int i = 1; i < heroList.size(); i++) {
            float tmp = getPosition().getDistance(heroList.get(i).getPosition().x, heroList.get(i).getPosition().y);
            if (tmp < minDistance) {
                minDistance = tmp;
                minIndex = i;
            }
            //           System.out.println(getPosition().getDistance(target.getPosition().x, target.getPosition().y));
        }
        return new Vector2(minDistance, minIndex);
    }
}

