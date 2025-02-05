package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double discountPercent;

    public PercentDiscountPolicy(
            double discountPercent,
            DiscountCondition... discountConditions) {
        super(List.of(discountConditions));
        this.discountPercent = discountPercent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(discountPercent);
    }
}
