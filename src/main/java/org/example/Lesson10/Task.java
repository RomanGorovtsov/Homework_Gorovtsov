package org.example.Lesson10;

public class Task {

    // Внутренние характеристики (поля класса)
    private String title;
    private boolean isDone;

    // Конструктор: при создании задача всегда не выполнена
    public Task(String title) {
        this.title = title;
        this.isDone = false;
    }

    // Пометить задачу как выполненную
    public void markAsDone() {
        this.isDone = true;
    }

    // Получить статус — выполнена задача или нет
    public boolean isDone() {
        return this.isDone;
    }

    // Получить название задачи
    public String getTitle() {
        return this.title;
    }

    // Вывести информацию о задаче
    public void displayInfo() {
        char mark = this.isDone ? 'x' : ' ';
        System.out.printf("[%c] %s%n", mark, this.title);
    }
}

