package org.web.core.exceptions;

public class NoPublicationDateException extends Exception {
    public NoPublicationDateException() {
    }

    public NoPublicationDateException(String s) {
        super(s);
    }

    public NoPublicationDateException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoPublicationDateException(Throwable throwable) {
        super(throwable);
    }

    public NoPublicationDateException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
