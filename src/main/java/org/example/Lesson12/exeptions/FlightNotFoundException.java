package org.example.Lesson12.exeptions;

public class FlightNotFoundException extends AirportServiceException {

    public FlightNotFoundException(String message) {
        super(message);
    }
}
