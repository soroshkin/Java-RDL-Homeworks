package ChainOfResponsibility;

public abstract class ABaseHandler implements IHandler {
    IHandler next;
}
