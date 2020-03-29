package State.states;

public enum Messages {
    COFFEE_MACHINE_IS_BUSY_MESSAGE("Coffee machine is busy"),
    INSERT_COIN("First off all insert coin"),
    COFFEE_IS_PREPARING_MESSAGE("Coffee is already preparing");
    private String message;

    public String getMessage() {
        return message;
    }

    Messages(String message) {
        this.message = message;
    }
}
