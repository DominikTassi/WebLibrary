package org.web.core.exceptions;

public class WrongISBNException extends Exception {
    public WrongISBNException() {
    }

    public WrongISBNException(String s) {
        super(s);
    }

    public WrongISBNException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public WrongISBNException(Throwable throwable) {
        super(throwable);
    }

    public WrongISBNException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
