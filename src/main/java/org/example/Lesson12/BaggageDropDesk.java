package org.example.Lesson12;

import org.example.Lesson12.exeptions.*;

import java.util.Arrays;

public class BaggageDropDesk {

    private String[] availableFlights;

    public BaggageDropDesk(String[] availableFlights) {
        if (availableFlights == null) {
            throw new IllegalArgumentException("Список доступных рейсов не может быть null!");
        }
        this.availableFlights = availableFlights;
    }

    public BaggageTicket baggageDropOff(String passengerName, String flightNumber, int baggageWeight)
            throws FlightNotFoundException, OverweightBaggageException, BaggageTagPrintException {

        if (passengerName == null || passengerName.isEmpty())
            throw new InvalidPassengerNameException("Имя пассажира не может быть пустым.");

        if (baggageWeight < 0) throw new InvalidBaggageWeightException("Вес багажа не может быть отрицательным.");

        if (Arrays.stream(availableFlights).noneMatch(flight -> flight.equals(flightNumber))) {
            throw new FlightNotFoundException("Рейс " + flightNumber + " не найден в базе данных аэропорта.");
        }

        if (baggageWeight > 23) throw new OverweightBaggageException("Вес багажа превышает 23 килограмма.");

        if (flightNumber.equals("AE-404")) throw new BaggageTagPrintException("Проблема с печатью бирки.");

        System.out.println("-> С вас взимается налог за идеальное заполнение полей: 10$.");
        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}
