package ChainOfResponsibility;

public abstract class ABaseHandler implements IHandler {
    IHandler next;

    @Override
    public void setNextHandler(IHandler handler) {
        next = handler;
    }

    @Override
    public void handle(Request request) {
        if (validate(request)) {
            System.out.printf("%d handled by %s%n", request.value, this.getClass().getSimpleName());
        } else {
            if (next != null) {
                next.handle(request);
            }
        }
    }
}
