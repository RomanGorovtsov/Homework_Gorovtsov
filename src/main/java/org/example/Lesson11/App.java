package org.example.Lesson11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество воды: ");
        try {
            int waterAmount = scanner.nextInt();
            coffeeMachine.makeCoffee(waterAmount);
            coffeeMachine.makeCoffee(100);

        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        } catch (NotEnoughWaterException e) {
            System.out.println("Ошибка приготовления: " + e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }


        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }


        String str1 = null;
        try {
            coffeeMachine.printCoffeeName(str1);
        } catch (RuntimeException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }
    }
}
