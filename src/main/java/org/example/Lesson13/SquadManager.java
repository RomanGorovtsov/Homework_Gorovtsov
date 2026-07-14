package org.example.Lesson13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {

    public void demonstrateListCreations() {
        ArrayList ar1 = new ArrayList<>();
        ar1.add("Jess");
        ar1.add("Jews");
        ar1.add("Rock");
        ar1.add("Leam");

        List<String> ar2 = Arrays.asList("Ric", "Bob", "Saul");

        List<String> ar3 = List.of("Tommy", "Polly");

        modifySquad(ar1, "Bob");
        modifySquad(ar2, "Rob");
        modifySquad(ar3, "Lob");

    }

    public void modifySquad(List<String> list, String soldier) {
        try {
            list.add(soldier);
        } catch (Exception e) {
            System.out.println("Нельзя добавить солдата " + soldier + " Перехвачено исключение: " + e.getClass().getSimpleName());
        }

        try {
            list.remove(soldier);
        } catch (Exception e) {
            System.out.println("Нельзя удалить солдата " + soldier + " Перехвачено исключение: " + e.getClass().getSimpleName());
        }
    }

    public void filterOutCowards(List<String> squad) {
        System.out.println("\nОтряд до фильтрации: ");
        for (String name : squad) {
            System.out.println(name);
        }

        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            if (name.startsWith("Трус")) {
                iterator.remove();
            }
        }


        System.out.println("\nОтряд после фильтрации: ");
        for (String name : squad) {
            System.out.println(name);
        }

        // squad.removeIf(name -> name.startsWith("Трус"));
    }
}





