package hello.oop.reuse.composition;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.util.ArrayList;
import java.util.List;

//계산을 수행하는 객체를 분리하고 해당 객체를 합성
public class Phone {

    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
