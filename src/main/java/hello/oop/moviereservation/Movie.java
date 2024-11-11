package hello.oop.moviereservation;

import java.time.Duration;

public class Movie {

    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee,
            DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        //version 0.0
//        if (discountPolicy == null) {
//            return fee;
//        }

        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    //이처럼 상속을 사용했을 때보다 합성을 사용했을 때, 유연하게 구현 객체를 변경할 수 있다
    //합성: 인터페이스에 정의된 메세지를 통해서만 코드를 재사용(구현에 대한 캡슐화 및 유연한 설계 가능)
    public void changeDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
