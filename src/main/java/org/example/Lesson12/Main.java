package org.example.Lesson12;

import org.example.Lesson12.exeptions.BaggageTagPrintException;
import org.example.Lesson12.exeptions.FlightNotFoundException;
import org.example.Lesson12.exeptions.OverweightBaggageException;
import org.example.Lesson12.exeptions.InvalidPassengerNameException;
import org.example.Lesson12.exeptions.InvalidBaggageWeightException;

public class Main {

    public static void main(String[] args) {

        String[] flights = {"SU-123", "TK-777", "KC-909", "AE-404"};

        BaggageDropDesk dropDesk = new BaggageDropDesk(flights);

        try {
            System.out.println("--- Сценарий 1: Успешная регистрация ---");
            BaggageTicket result = dropDesk.baggageDropOff("Ivan Petrov", "SU-123", 18);
            System.out.println("Успешно получен билет: " + result.toString());
        } catch (FlightNotFoundException e) {
            System.out.println("Ошибка: Рейс не найден. " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Ошибка: Перевес багажа. " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Ошибка: Проблема с принтером. " + e.getMessage());
        }

        try {
            System.out.println("\n--- Сценарий 2: Указанного пассажиром рейса не существует в базе ---");
            BaggageTicket result = dropDesk.baggageDropOff("Ivan Petrov", "SU-12345", 18);
            System.out.println("Успешно получен билет: " + result);
        } catch (FlightNotFoundException e) {
            System.out.println("Ошибка: Рейс не найден. " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Ошибка: Перевес багажа. " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Ошибка: Проблема с принтером. " + e.getMessage());
        }

        try {
            System.out.println("\n--- Сценарий 3: Багаж слишком тяжелый ---");
            BaggageTicket result = dropDesk.baggageDropOff("Ivan Petrov", "SU-123", 55);
            System.out.println("Успешно получен билет: " + result);
        } catch (FlightNotFoundException e) {
            System.out.println("Ошибка: Рейс не найден. " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Ошибка: Перевес багажа. " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Ошибка: Проблема с принтером. " + e.getMessage());
        }

        try {
            System.out.println("\n--- Сценарий 4: Проблема с печатью бирки ---");
            BaggageTicket result = dropDesk.baggageDropOff("Ivan Petrov", "AE-404", 12);
            System.out.println("Успешно получен билет: " + result);
        } catch (FlightNotFoundException e) {
            System.out.println("Ошибка: Рейс не найден. " + e.getMessage());
        } catch (OverweightBaggageException e) {
            System.out.println("Ошибка: Перевес багажа. " + e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.out.println("Ошибка: Проблема с принтером. " + e.getMessage());
        }

        try {
            System.out.println("\n--- Сценарий 5: Некорректное имя пассажира (null) ---");
            BaggageTicket result = dropDesk.baggageDropOff(null, "SU-123", 12);
            System.out.println("Успешно получен билет: " + result);
        } catch (InvalidPassengerNameException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: Другое исключение. " + e.getMessage());
        }

        try {
            System.out.println("\n--- Сценарий 6: Вес багажа отрицательный ---");
            BaggageTicket result = dropDesk.baggageDropOff("Ivan Petrov", "SU-123", -18);
            System.out.println("Успешно получен билет: " + result);
        } catch (InvalidBaggageWeightException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ошибка: Другое исключение. " + e.getMessage());
        }
    }
}
