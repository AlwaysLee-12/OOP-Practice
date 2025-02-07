package hello.oop.reuse.composition;

import hello.oop.moviereservation.reponsibilitydriven.Money;

//합성을 통해 부가적인 기능 추가
public abstract class AdditionalRatePolicy implements RatePolicy {

    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee);
    }

    abstract protected Money afterCalculated(Money fee);
}
