package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public class OverlappedDiscountPolicy extends DefaultDiscountPolicy {

    private final List<DefaultDiscountPolicy> discountPolicies;

    public OverlappedDiscountPolicy(List<DiscountCondition> discountConditions,
            List<DefaultDiscountPolicy> discountPolicies) {
        super(discountConditions);
        this.discountPolicies = discountPolicies;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        Money result = Money.ZERO;

        for (DefaultDiscountPolicy each : discountPolicies) {
            result.plus(each.calculateDiscountAmount(screening));
        }

        return result;
    }
}
