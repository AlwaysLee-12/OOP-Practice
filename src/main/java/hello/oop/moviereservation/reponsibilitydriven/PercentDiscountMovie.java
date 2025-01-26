package hello.oop.moviereservation.reponsibilitydriven;

import java.time.Duration;
import java.util.List;

public class PercentDiscountMovie extends Movie {

    private double discountPercent;

    public PercentDiscountMovie(
            String title,
            Duration runningTime,
            Money fee,
            double discountPercent,
            DiscountCondition... discountConditions) {
        super(title, runningTime, fee, List.of(discountConditions));
        this.discountPercent = discountPercent;
    }

    @Override
    public Money calculateDiscountAmount() {
        return getFee().times(discountPercent);
    }
}
