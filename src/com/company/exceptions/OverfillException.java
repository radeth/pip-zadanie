package com.company.exceptions;

public class OverfillException extends Throwable {
    public OverfillException(String id) {
        System.out.println("Container id: " + id + " has been overfilled");
    }
}
