package org.example.Lesson11;

public class CoffeeMachine {

    public void makeCoffee(int waterAmount) throws NotEnoughWaterException {
        if (waterAmount <= 200)
            throw new NotEnoughWaterException("Недостаточно воды: имеется  " + waterAmount + " мл, а требуется больше 200 мл.");
        else System.out.println("Кофе приготовлен");
    }

    public void calculateCups(int waterAmount, int cupVolume) {
        if (cupVolume == 0) throw new ArithmeticException();
        else System.out.println("Столько чашек кофе можно приготовить: " + (waterAmount / cupVolume));
    }

    public void printCoffeeName(String coffeeName) {
        if (coffeeName == null) throw new NullPointerException();
        else System.out.println(coffeeName.toUpperCase());
    }
}
