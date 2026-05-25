package org.example.Lesson7.arena.heroes;

public class App {

    public static void main(String[] args) {

        Hero[] heroes = {
                new Knight("Chaos Knight", 87, 100, 50),
                new Archer("Clinkz", 55, 80, 25),
                new Mage("Invoker", 90, 60, 200)
        };

        for (Hero hero: heroes) {
            hero.printInfo();
            hero.attack();
        }

        final Knight knight = new Knight("Abaddon", 66, 99, 80);
        System.out.println(knight.toString());
        knight.setLevel(99);
        System.out.println(knight.toString());
    }
}
