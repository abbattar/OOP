package Heroes;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
  protected boolean isEnemy;
  protected String name, role;
  protected int attack, defence, health, maxHealth, speed;
  protected int[] damage;

  public BaseHero(String name, String role, int attack, int defence, int[] damage,
                  int health, int speed, boolean isEnemy) {
    this.role =role;
    this.name = name;
    this.attack = attack;
    this.defence = defence;
    this.damage = damage;
    this.health = health;
    this.maxHealth = health;
    this.health = maxHealth - new Random().nextInt(maxHealth);
    this.speed = speed;
    this.isEnemy = isEnemy;
  }

  public void step(ArrayList<BaseHero> heroList) {
  }

  public String getInfo() {
    return name + " " + role + " ОЗ.: " + health * 100 / maxHealth + " % [ " + maxHealth + " ]";
  }   // ОЗ - очки здоровья

  @Override
  public String toString() {
    return "Имя: " + name + ", Роль: " + role + ", Атака: " + attack + ", Защита: " + defence + ", Урон: " + Arrays.toString(damage) + ", Здоровье: " + health + ", Скорость: " + speed;
  }
}