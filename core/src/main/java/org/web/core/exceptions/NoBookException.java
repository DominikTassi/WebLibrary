package org.web.core.exceptions;

public class NoBookException extends Exception {
    public NoBookException() {
    }

    public NoBookException(String s) {
        super(s);
    }

    public NoBookException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoBookException(Throwable throwable) {
        super(throwable);
    }

    public NoBookException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
