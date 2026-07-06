package org.example.Lesson12.exeptions;

public class OverweightBaggageException extends AirportServiceException {

    public OverweightBaggageException(String message) {
        super(message);
    }
}
