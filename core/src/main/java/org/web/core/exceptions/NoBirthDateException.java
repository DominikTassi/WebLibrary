package org.web.core.exceptions;

public class NoBirthDateException extends Exception {
    public NoBirthDateException() {
    }

    public NoBirthDateException(String s) {
        super(s);
    }

    public NoBirthDateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoBirthDateException(Throwable throwable) {
        super(throwable);
    }

    public NoBirthDateException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
