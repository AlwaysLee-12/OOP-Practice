package hello.oop.moviereservation.reponsibilitydriven;

import java.time.Duration;
import java.util.List;

public class NoneDiscountMovie extends Movie {

    public NoneDiscountMovie(
            String title,
            Duration runningTime,
            Money fee,
            DiscountCondition... discountConditions) {
        super(title, runningTime, fee, List.of(discountConditions));
    }

    @Override
    protected Money calculateDiscountAmount() {
        return Money.ZERO;
    }
}
