package hello.oop.moviereservation.reponsibilitydriven;

import java.time.Duration;

// Movie에도 Polymophism + Protected Variation 적용
// 상속을 이용한 다형성의 적용은 할인 조건이 추가 될 때마다 인스턴스 추가 생성 및 생성자를 위한 동일 코드 복사 과정이 중복 수행
// 합성을 이용한 방법으로 변경 -> 유연성 증가
public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;
//    private List<DiscountCondition> discountConditons;

//    private MovieType movieType;
//    private Money discountAmount;
//    private double discountPercent;


    public Movie(
            String title,
            Duration runningTime,
            Money fee,
            DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
//        this.discountConditons = discountConditions;
    }

    public Money calculateMovieFee(Screening screening) {
//        if (isDiscountable(screening)) {
//            return fee.minus(discountPolicy.calculateDiscountAmount());
//        }
//
//        return fee;
        return discountPolicy.calculateDiscountAmount(screening);
    }

//    private boolean isDiscountable(Screening screening) {
//        return discountConditons.stream()
//                .anyMatch(condition -> condition.isSatisfiedBy(screening));
//    }

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

//    abstract protected Money calculateDiscountAmount();
}
