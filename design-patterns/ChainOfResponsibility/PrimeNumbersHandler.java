package ChainOfResponsibility;

import java.math.BigInteger;

public class PrimeNumbersHandler extends ABaseHandler {
    @Override
    public boolean validate(Request request) {
        BigInteger bigInteger = BigInteger.valueOf(request.value);
        //99.9% probability
        return bigInteger.isProbablePrime(10);
    }
}
