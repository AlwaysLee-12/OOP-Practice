package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public class OverlappedDiscountPolicy extends DiscountPolicy{

    private final List<DiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(List<DiscountCondition> discountConditions,
            List<DiscountPolicy> discountPolicies) {
        super(discountConditions);
        this.discountPolicies = discountPolicies;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;

        for (DiscountPolicy each : discountPolicies) {
            result.plus(each.calculateDiscountAmount(screening));
        }

        return result;
    }
}
