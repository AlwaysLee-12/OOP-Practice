package hello.oop.moviereservation.reponsibilitydriven;

import java.time.Duration;
import java.util.List;


// Movie에도 Polymophism + Protected Variation 적용
public abstract class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditons;

//    private MovieType movieType;
//    private Money discountAmount;
//    private double discountPercent;


    public Movie(
            String title,
            Duration runningTime,
            Money fee,
            List<DiscountCondition> discountConditions) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountConditons = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }

        return fee;
    }

    private boolean isDiscountable(Screening screening) {
        return discountConditons.stream()
                .anyMatch(condition -> condition.isSatisfiedBy(screening));
    }

    public Money getFee() {
        return fee;
    }

    //    private Money calculateDiscountAmount() {
//        switch (movieType) {
//            case AMOUNT_DISCOUNT:
//                return calculateAmountDiscountAmount();
//            case PERCENT_DISCOUNT:
//                return calculatePercentDiscountAmount();
//            case NONE_DISCOUNT:
//                return calculateNoneDiscountAmount();
//            default:
//                throw new IllegalStateException();
//        }
//    }

//    private Money calculateAmountDiscountAmount() {
//        return discountAmount;
//    }

//    private Money calculatePercentDiscountAmount() {
//        return fee.times(discountPercent);
//    }

    abstract protected Money calculateDiscountAmount();
}
