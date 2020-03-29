package Factory;

public class EmptyTransportException extends Exception {
    public EmptyTransportException() {
    }

    public EmptyTransportException(String message) {
        super(message);
    }

    public EmptyTransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyTransportException(Throwable cause) {
        super(cause);
    }
}
