package org.example.Lesson12;

public class BaggageTicket {

    private String passengerName;
    private String flightNumber;
    private int baggageWeight;


    public BaggageTicket(String passengerName, String flightNumber, int baggageWeight) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public int getBaggageWeight() {
        return baggageWeight;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    @Override
    public String toString() {
        return "имя пассажира = " + passengerName +
                ", номер полета= " + flightNumber +
                ", вес багажа = " + baggageWeight +
                '}';
    }
}
