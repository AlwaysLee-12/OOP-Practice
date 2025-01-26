package hello.oop.moviereservation.reponsibilitydriven;

import java.time.Duration;
import java.util.List;

public class AmountDiscountMovie extends Movie {

    private Money discountAmount;

    public AmountDiscountMovie(
            String title,
            Duration runningTime,
            Money fee,
            Money discountAmount,
            DiscountCondition... discountConditions) {
        super(title, runningTime, fee, List.of(discountConditions));
        this.discountAmount = discountAmount;
    }

    @Override
    public Money calculateDiscountAmount() {
        return discountAmount;
    }
}
