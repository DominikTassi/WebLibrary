package org.web.core.exceptions;

public class NoBorrowException extends Exception {
    public NoBorrowException() {
    }

    public NoBorrowException(String message) {
        super(message);
    }

    public NoBorrowException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoBorrowException(Throwable cause) {
        super(cause);
    }

    public NoBorrowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
