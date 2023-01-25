import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
  protected String name, role;
  protected int attack, defence, health, maxHealth, speed;
  protected int[] damage;

  public BaseHero(String name, String role, int attack, int defence, int[] damage,
                  int health, int speed) {
    this.role =role;
    this.name = name;
    this.attack = attack;
    this.defence = defence;
    this.damage = damage;
    this.health = health;
    this.maxHealth = health;
    this.health = maxHealth - new Random().nextInt(maxHealth);
    this.speed = speed;
  }
  public int getHealth(){
    return (int) health / maxHealth * 100;
  }
  @Override
  public void step(ArrayList<BaseHero> heroList) {
  }

  @Override
  public String getInfo() {
    return name + " " + role + " ОЗ.:" + health + "/" + maxHealth;
  }

  @Override
  public String toString() {
    return "Имя: " + name + ", Роль: " + role + ", Атака: " + attack + ", Защита: " + defence + ", Урон: " + Arrays.toString(damage) + ", Здоровье: " + health + ", Скорость: " + speed;
  }
}