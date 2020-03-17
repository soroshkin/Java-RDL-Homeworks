package producerconsumer;

public class Message {
    private String data;

    public Message(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data;
    }
}
