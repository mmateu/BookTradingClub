package com.example.BookTradingClub.service.exception;

public class AcceptDecisionAlreadyTakenException extends RuntimeException {
    public AcceptDecisionAlreadyTakenException(String message) {
        super(message);
    }
}