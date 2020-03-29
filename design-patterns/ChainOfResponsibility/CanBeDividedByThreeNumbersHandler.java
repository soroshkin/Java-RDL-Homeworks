package ChainOfResponsibility;

public class CanBeDividedByThreeNumbersHandler extends ABaseHandler {

    @Override
    public boolean validate(Request request) {
        return request.value % 3 == 0;
    }
}
