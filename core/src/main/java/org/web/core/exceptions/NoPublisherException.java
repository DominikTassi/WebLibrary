package org.web.core.exceptions;

public class NoPublisherException extends Exception {
    public NoPublisherException() {
    }

    public NoPublisherException(String s) {
        super(s);
    }

    public NoPublisherException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoPublisherException(Throwable throwable) {
        super(throwable);
    }

    public NoPublisherException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
