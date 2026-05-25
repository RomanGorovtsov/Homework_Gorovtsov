package org.example.Lesson7.arena.heroes;

public class Knight extends Hero{

    private int armor;

    public Knight() {
        super();
    }

    public Knight(String name, int level, int health, int armor) {
        super(name, level, health);
        this.armor = armor;
    }

    @Override
    public void attack(){
        System.out.println("Рыцарь бьёт мечом!");
    }

    @Override
    public String toString() {
        return String.format("Рыцарь [Имя: %s, Уровень: %d, Здоровье: %d, Броня: %d]", getName(), getLevel(), getHealth(), getArmor());
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }
}
