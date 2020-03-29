package Builder.recipients;

public class RecipientNotAddedException extends Exception{
    public RecipientNotAddedException() {
    }

    public RecipientNotAddedException(String message) {
        super(message);
    }

    public RecipientNotAddedException(String message, Throwable cause) {
        super(message, cause);
    }

    public RecipientNotAddedException(Throwable cause) {
        super(cause);
    }
}
