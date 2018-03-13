package org.web.core.exceptions;

public class WrongPieceException extends Exception {
    public WrongPieceException() {
    }

    public WrongPieceException(String s) {
        super(s);
    }

    public WrongPieceException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WrongPieceException(Throwable throwable) {
        super(throwable);
    }

    public WrongPieceException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
