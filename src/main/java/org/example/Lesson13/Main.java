package org.example.Lesson13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<Alien> aliens = new ArrayList<>();

        Alien alien1 = new Alien("Bob", "Earth", 3);
        Alien alien2 = new Alien("Bob", "Earth", 5);
        Alien alien3 = new Alien("Bobby", "Earth", 4);
        Alien alien4 = new Alien("John", "Mars", 3);
        Alien alien5 = new Alien("Brad", "Jupiter", 7);

        aliens.add(alien1);
        aliens.add(alien2);
        aliens.add(alien3);
        aliens.add(alien4);
        aliens.add(alien5);

        HashSet<Alien> aliensHashSet = new HashSet<>(aliens);

        System.out.println("Есть ли дубликат? - " + (aliens.size() != aliensHashSet.size()));

        //2
        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        //3
        List<String> combatSquad = new ArrayList<>();
        combatSquad.add("John");
        combatSquad.add("Трус Вася");
        combatSquad.add("Marcus");
        combatSquad.add("Трус Петя");
        combatSquad.add("David");

        squadManager.filterOutCowards(combatSquad);

        //4
        AssaultQueue assaultQueue = new AssaultQueue();

        System.out.println("=== Шаг 2: Добавление 5 человек ===");
        assaultQueue.addRecruit("John");
        assaultQueue.addRecruit("Marcus");
        assaultQueue.addRecruit("David");
        assaultQueue.addRecruit("Cole");
        assaultQueue.addRecruit("Baird");
        assaultQueue.printQueue();

        System.out.println("\n=== Шаг 3: Уход 2 человек из начала очереди ===");
        String coward1 = assaultQueue.retreatCoward();
        System.out.println("Покинул очередь: " + coward1);

        String coward2 = assaultQueue.retreatCoward();
        System.out.println("Покинул очередь: " + coward2);

        assaultQueue.printQueue();

        System.out.println("\n=== Шаг 4: Добавление 3 новых в конец ===");
        assaultQueue.addRecruit("Sam");
        assaultQueue.addRecruit("Jace");
        assaultQueue.addRecruit("Dom");
        assaultQueue.printQueue();

        System.out.println("\n=== Шаг 5: Итоговое состояние очереди (через toString) ===");
        System.out.println(assaultQueue);

        //5
        List<Alien> aliens5 = new ArrayList<>();
        aliens.add(new Alien("Bob", "Earth", 3));
        aliens.add(new Alien("John", "Mars", 5));
        aliens.add(new Alien("Brad", "Jupiter", 7));

        // 1. Создайте объект отчёта и выведите его на экран
        System.out.println("=== Шаг 1: Первый отчет ===");
        MissionReport report1 = new MissionReport("Штурм Зоны 51", aliens5, 50);
        System.out.println(report1);

        // 2. Создайте второй отчёт с теми же данными
        // Создаем новые объекты пришельцев с теми же данными, чтобы списки были эквивалентны
        List<Alien> aliens25 = new ArrayList<>();
        aliens25.add(new Alien("Bob", "Earth", 3));
        aliens25.add(new Alien("John", "Mars", 5));
        aliens25.add(new Alien("Brad", "Jupiter", 7));

        MissionReport report2 = new MissionReport("Штурм Зоны 51", aliens25, 50);

        // 3. Сравните их через == и через equals(). Выведите результаты
        System.out.println("\n=== Шаг 3: Сравнение отчетов ===");

        boolean compareByReferences = (report1 == report2);
        System.out.println("Сравнение через == (ссылки в памяти): " + compareByReferences);
        // Выведет false, так как это два разных объекта в куче (heap)

        boolean compareByEquals = report1.equals(report2);
        System.out.println("Сравнение через equals() (по содержимому): " + compareByEquals);
        // Выведет true, так как все поля внутри объектов полностью идентичны
    }
}

