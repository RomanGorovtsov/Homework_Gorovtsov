package org.example.Lesson10;

import java.util.ArrayList;
import java.util.List;

public class TaskTracker {
    // Список для хранения объектов задач
    private List<Task> tasks;

    // Конструктор
    public TaskTracker() {
        this.tasks = new ArrayList<>();
    }

    // Добавить новую задачу в список
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Вывести все задачи
    public void displayAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Список задач пуст.");
            return;
        }
        for (Task task : tasks) {
            task.displayInfo();
        }
    }

    // метод для поиска задачи по названию внутри класса
    private Task findTaskByTitle(String title) {
        for (Task task : tasks) {
            if (task.getTitle().equalsIgnoreCase(title)) {
                return task;
            }
        }
        return null;
    }

    // Найти задачу по названию и вывести информацию о ней
    public void searchAndDisplayTask(String title) {
        Task task = findTaskByTitle(title);
        if (task != null) {
            task.displayInfo();
        } else {
            System.out.println("Задача не найдена");
        }
    }

    // Пометить задачу как сделанную по ее имени
    public void markTaskAsDone(String title) {
        Task task = findTaskByTitle(title);
        if (task != null) {
            task.markAsDone();
        } else {
            System.out.println("Задача для отметки не найдена");
        }
    }

    // Вывести статистику по задачам
    public void displayStatistics() {
        int total = tasks.size();
        int doneCount = 0;

        for (Task task : tasks) {
            if (task.isDone()) {
                doneCount++;
            }
        }

        int openCount = total - doneCount;

        System.out.println("Всего задач: " + total);
        System.out.println("Выполнено: " + doneCount);
        System.out.println("Открыто: " + openCount);
    }
}

