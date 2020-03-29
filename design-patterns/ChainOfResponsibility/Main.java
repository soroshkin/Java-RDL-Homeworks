package ChainOfResponsibility;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        final int integerListCapacity = 20;
        final int maxNumber = 300;
        final int minNumber = 10;

        Random random = new Random();
        //to avoid duplicate numbers
        Set<Request> requests = random.ints(minNumber, maxNumber)
                .mapToObj(Request::new)
                .limit(integerListCapacity)
                .collect(Collectors.toSet());

        IHandler evenNumbersHandler = new EvenNumbersHandler();
        IHandler primeNumbersHandler = new PrimeNumbersHandler();
        IHandler canBeDividedByThreeNumbersHandler = new CanBeDividedByThreeNumbersHandler();
        IHandler errorsHandler = new ErrorsHandler();

        evenNumbersHandler.setNextHandler(primeNumbersHandler);
        primeNumbersHandler.setNextHandler(canBeDividedByThreeNumbersHandler);
        canBeDividedByThreeNumbersHandler.setNextHandler(errorsHandler);

        requests.forEach(evenNumbersHandler::handle);
    }
}
