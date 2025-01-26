package hello.oop.moviereservation.reponsibilitydriven;

import java.util.List;

public abstract class DiscountPolicy {

    private List<DiscountCondition> discountConditions;

    public DiscountPolicy(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : discountConditions
        ) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
