package Heroes;

import BatleField.Vector2;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {

    protected String name, role;
    protected List<BaseHero> gang;
    protected int attack;
    protected int defence;
    protected int speed;
    public int maxHealth;
    public float health;
    protected int[] damage;
    protected Vector2 position;

    public BaseHero(List<BaseHero> gang, String name, String role, int attack, int defence, int[] damage,
                    int maxHealth, int speed, Vector2 position) {
        this.role = role;
        this.name = name;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.health = (float) maxHealth;
        this.speed = speed;
        this.position = position;
        this.gang = gang;
    }

    public void step(ArrayList<BaseHero> heroList) {
    }

    public String getInfo() {
        //return name + " " + role + " ОЗ.: " + health * 100 / maxHealth + " % [ " + maxHealth + " ]";
        return String.format("%-10s %-13s %s: %-3d/ %-3d %s: %-5d |", role, name, "\uD83E\uDDE1", (int) health, maxHealth, "⚔", attack);
    }   // ОЗ - очки здоровья

    @Override
    public String toString() {
        return "Имя: " + name + ", Роль: " + role + ", Атака: " + attack +
                ", Защита: " + defence + ", Урон: " + Arrays.toString(damage) +
                ", Здоровье: " + health + ", Скорость: " + speed + ", Расположение: " + position.toString();
    }

    public Vector2 getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    public String getRole() {
        return role;
    }

    public float getHealth() {
        return health / maxHealth * 100;
    }

    public void getDamage(float damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        } else {
            this.health = maxHealth;
        }
        System.out.println(this.name + " " + this.health);
    }
}