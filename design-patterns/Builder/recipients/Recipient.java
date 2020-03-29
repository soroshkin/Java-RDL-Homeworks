package Builder.recipients;

public class Recipient extends ARecipient {
    @Override
    public void create(String username, String address) {
        this.username = username;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Recipient{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
