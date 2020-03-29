package ChainOfResponsibility;

public class ErrorsHandler extends ABaseHandler{
    @Override
    public boolean validate(Request request) {
        return true;
    }
}
