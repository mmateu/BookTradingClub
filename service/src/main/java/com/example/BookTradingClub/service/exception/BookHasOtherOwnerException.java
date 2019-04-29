package com.example.BookTradingClub.service.exception;

public class BookHasOtherOwnerException extends RuntimeException{
    public BookHasOtherOwnerException(String message) {
        super(message);
    }

    public BookHasOtherOwnerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookHasOtherOwnerException(String bookTitle, String validOwner, String invalidOwner) {
        super(
                " '"+ bookTitle +"' belongs to another user. "+
                        "Expected: "+ validOwner+" "+
                "Found: "+ invalidOwner
        );
    }
}
