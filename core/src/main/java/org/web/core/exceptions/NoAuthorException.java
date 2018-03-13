package org.web.core.exceptions;

public class NoAuthorException extends Exception {
    public NoAuthorException() {
    }

    public NoAuthorException(String s) {
        super(s);
    }

    public NoAuthorException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoAuthorException(Throwable throwable) {
        super(throwable);
    }

    public NoAuthorException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
