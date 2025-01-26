package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public class NoneDiscountPolicy extends DiscountPolicy {

    public NoneDiscountPolicy(List<DiscountCondition> discountConditions) {
        super(discountConditions);
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
