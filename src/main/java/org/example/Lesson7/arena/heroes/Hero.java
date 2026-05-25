package org.example.Lesson7.arena.heroes;

public abstract class Hero {

    public static final int MAX_LEVEL = 100;
    public static int heroesCreated = 0;

    private String name;
    private int level;
    private int health;

    public Hero(){
        heroesCreated++;
    }

    public Hero(String name, int level, int health) {
        this.name = name;
        this.level = Math.min(level, MAX_LEVEL);
        this.health = Math.max(health, 0);
        heroesCreated++;
    }


    public void printInfo() {
        System.out.printf("Имя героя: %s, уровень героя: %s, текущее здоровье: %s%n", name, level, health);
    }

    public void takeDamage(int damage) {
        health = Math.max(health - damage, 0);
    }

    public void levelUp() {
        level = Math.min(level+1, MAX_LEVEL);
    }

    public void attack(){
        System.out.println("Герой наносит обычный удар.");
    }

    public void attack(String target){
        System.out.printf("Герой наносит обычный удар. Цель: %s%n", target);
    }

    public void attack(String target, int times){
        System.out.printf("Герой атакует цель %s %d количество-раз.%n", target, times);
    }

    public static void printHeroesCreated(){
        System.out.printf("Всего создано героев: %d%n", heroesCreated);
    }

    public final void rest(){
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }

    public static int getHeroesCreated() {
        return heroesCreated;
    }

    public static void setHeroesCreated(int heroesCreated) {
        Hero.heroesCreated = heroesCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
