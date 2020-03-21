package io.humb1t.exceptions;

public class NoSuchClassException extends Exception {
    public NoSuchClassException() {
    }

    public NoSuchClassException(String message) {
        super(message);
    }

    public NoSuchClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchClassException(Throwable cause) {
        super(cause);
    }
}
