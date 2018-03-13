package org.web.core.exceptions;

public class NoPasswordException extends Exception {
    public NoPasswordException() {
    }

    public NoPasswordException(String s) {
        super(s);
    }

    public NoPasswordException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoPasswordException(Throwable throwable) {
        super(throwable);
    }

    public NoPasswordException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
