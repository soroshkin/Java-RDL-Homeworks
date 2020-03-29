package ChainOfResponsibility;

public class Request {
    int value;

    public int getValue() {
        return value;
    }

    public Request(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Request{" +
                "value=" + value +
                '}';
    }
}
