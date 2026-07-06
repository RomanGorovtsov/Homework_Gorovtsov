package org.example.Lesson12.exeptions;

public class InvalidBaggageWeightException extends RuntimeException{
    public InvalidBaggageWeightException(String message) {
        super(message);
    }
}
