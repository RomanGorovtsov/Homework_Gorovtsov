package org.example.Lesson10;

public class Main {
    public static void main(String[] args) {
        TaskTracker tracker = new TaskTracker();

        // 1. Добавляем задачи
        tracker.addTask(new Task("Проверить авторизацию"));
        tracker.addTask(new Task("Проверить регистрацию"));
        tracker.addTask(new Task("Написать тесты"));

        // 2. Помечаем одну задачу как выполненную
        tracker.markTaskAsDone("Проверить регистрацию");

        // 3. Выводим все задачи
        System.out.println("--- Все задачи ---");
        tracker.displayAllTasks();

        // 4. Поиск задач
        System.out.println("\n--- Поиск задач ---");
        tracker.searchAndDisplayTask("Написать тесты");
        tracker.searchAndDisplayTask("Купить молоко");

        // 5. Вывод статистики
        System.out.println("\n--- Статистика ---");
        tracker.displayStatistics();
    }
}
