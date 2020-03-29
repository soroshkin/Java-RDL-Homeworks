package ChainOfResponsibility;

public class EvenNumbersHandler extends ABaseHandler {

    @Override
    public boolean validate(Request request) {
        return request.value % 2 == 0;
    }
}
