package org.example.Lesson12.exeptions;

public class ConveyorBeltMalfunctionError extends Error{
    public ConveyorBeltMalfunctionError(String message) {
        super(message);
    }
}
