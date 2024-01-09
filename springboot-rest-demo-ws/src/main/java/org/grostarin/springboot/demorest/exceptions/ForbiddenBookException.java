package org.grostarin.springboot.demorest.exceptions;

public class ForbiddenBookException extends RuntimeException {

    public ForbiddenBookException() {
        super();
    }

    public ForbiddenBookException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ForbiddenBookException(final String message) {
        super(message);
    }

    public ForbiddenBookException(final Throwable cause) {
        super(cause);
    }
}