package Factory;

public class NoSuchTransportException extends Exception {
    public NoSuchTransportException() {
    }

    public NoSuchTransportException(String message) {
        super(message);
    }

    public NoSuchTransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchTransportException(Throwable cause) {
        super(cause);
    }
}
