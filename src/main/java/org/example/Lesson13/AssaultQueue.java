package org.example.Lesson13;

import java.util.LinkedList;

public class AssaultQueue {
    private LinkedList<String> queue = new LinkedList<>();

    public void addRecruit(String name) {
        queue.addLast(name);
    }

    public String retreatCoward() {
        if (queue.isEmpty()) {
            return "Очередь пуста";
        }
        return queue.removeFirst();
    }

    public void printQueue() {
        System.out.println("Текущее состояние очереди: " + queue);
    }

    @Override
    public String toString() {
        return "Штурмовая очередь (Всего бойцов: " + queue.size() + "): " + queue;
    }
}
