package org.example.Lesson12.exeptions;

public class InvalidPassengerNameException extends RuntimeException {
    public InvalidPassengerNameException(String message) {
        super(message);
    }
}
