package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {

    private Money discountAmount;

    public AmountDiscountPolicy(
            Money discountAmount,
            DiscountCondition... discountConditions) {
        super(List.of(discountConditions));
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
