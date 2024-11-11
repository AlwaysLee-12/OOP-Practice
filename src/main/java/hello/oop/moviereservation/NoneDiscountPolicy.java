package hello.oop.moviereservation;

public class NoneDiscountPolicy extends DiscountPolicy {

    //할인 가격이 0원일 경우에 대한 처리의 책임이 이 이전 버전(0.0)에는 Movie에 있었음
    //이를 본 구현체를 생성함으로써 DiscountPolicy가 0원인 경우도 처리하게 위임
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
