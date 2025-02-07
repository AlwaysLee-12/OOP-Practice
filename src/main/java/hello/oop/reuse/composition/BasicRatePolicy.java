package hello.oop.reuse.composition;

import hello.oop.moviereservation.reponsibilitydriven.Money;

public abstract class BasicRatePolicy implements RatePolicy {


    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
