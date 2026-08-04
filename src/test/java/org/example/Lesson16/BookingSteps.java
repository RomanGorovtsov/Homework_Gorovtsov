package org.example.Lesson16;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.ru.*;
import java.util.List;
import java.util.Map;

public class BookingSteps {

    // === БЛОК 4. Data Table (Заменил одиночные Given из Предыстории) ===
    @Дано("в ресторане есть следующие столики:")
    public void configTables(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (Map<String, String> row : rows) {
            System.out.println("LOG-TABLE: Создан столик №" + row.get("номер") + " вместимостью " + row.get("вместимость"));
        }
    }

    // === БЛОК 1. Базовые шаги ===
    @Когда("гость создает бронирование на {int} человека на время {string}")
    public void createBooking(int guests, String time) {
        System.out.println("LOG: Запрос брони на " + guests + " человек на время " + time);
    }

    @Тогда("бронирование успешно подтверждается")
    public void bookingConfirmed() {
        System.out.println("LOG: Бронь успешно подтверждена");
    }

    @И("столик номер {int} становится занятым")
    public void tableBecomesOccupied(int tableNumber) {
        System.out.println("LOG: Столик №" + tableNumber + " теперь занят");
    }

    @Тогда("гость получает отказ в бронировании")
    public void bookingRejected() {
        System.out.println("LOG: Система выдала отказ в бронировании");
    }

    @И("система сообщает, что подходящих столиков нет")
    public void systemReportsNoTables() {
        System.out.println("LOG: Выведено сообщение: Подходящих столиков нет");
    }

    @Дано("у гостя есть подтвержденное бронирование столика номер {int} на время {string}")
    public void existingBooking(int tableNumber, String time) {
        System.out.println("LOG: Найдено активное бронирование столика №" + tableNumber + " на " + time);
    }

    @Когда("гость отменяет свое бронирование")
    public void cancelBooking() {
        System.out.println("LOG: Гость запросил отмену брони");
    }

    @Тогда("бронирование аннулируется")
    public void bookingCanceled() {
        System.out.println("LOG: Бронирование аннулировано");
    }

    @И("столик номер {int} становится свободным")
    public void tableBecomesFree(int tableNumber) {
        System.out.println("LOG: Столик №" + tableNumber + " освобожден и доступен");
    }

    // === БЛОК 5. Doc String ===
    @Когда("гость оставляет пожелание к брони:")
    public void addBookingComment(String comment) {
        System.out.println("LOG-DOCSTRING: Получено особое пожелание клиента:\n" + comment);
    }

    // === БЛОК 3. Scenario Outline ===
    @Дано("в системе создан тестовый столик номер {int} вместимостью {int} мест")
    public void configTestTable(int tableNumber, int capacity) {
        System.out.println("LOG-OUTLINE: Инициализирован стол №" + tableNumber + " на " + capacity + " мест");
    }

    @Когда("новый гость пытается забронировать места на {int} человек")
    public void tryCreateBooking(int guests) {
        System.out.println("LOG-OUTLINE: Попытка забронировать на " + guests + " человек");
    }

    @Тогда("система должна выдать результат: {string}")
    public void checkBookingResult(String expectedResult) {
        System.out.println("LOG-OUTLINE: Проверка результата. Ожидается: " + expectedResult);
    }

    // === БЛОК 8*. Регулярные выражения (Один метод ловит и "увеличивает", и "уменьшает") ===
    @Когда("^гость (увеличивает|уменьшает) бронь на (\\d+) человека$")
    public void modifyBookingGuests(String action, int count) {
        System.out.println("LOG-REGEX: Действие '" + action + "' на " + count + " чел.");
    }
}
