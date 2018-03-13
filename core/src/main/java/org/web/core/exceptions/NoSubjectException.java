package org.web.core.exceptions;

public class NoSubjectException extends Exception {
    public NoSubjectException() {
    }

    public NoSubjectException(String s) {
        super(s);
    }

    public NoSubjectException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public NoSubjectException(Throwable throwable) {
        super(throwable);
    }

    public NoSubjectException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
