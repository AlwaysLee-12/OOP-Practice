package hello.oop.moviereservation.datadriven;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Movie {

    //Movie가 포함해야 하는 데이터는 무엇인가?(데이터 중심 설계 -> Movie의 책임은 영화의 기본 정보 관리 + 할인 금액 계산)
    //영화의 기본 정보
    private String title;
    private Duration runningTime;
    private Money fee;
    //할인 조건의 목록
    private List<DiscountCondition> discountConditions;

    //할인 정책(Movie가 할인 금액을 계산하는데 필요한 데이터)
    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Money getFee() {
        return fee;
    }

    public List<DiscountCondition> getDiscountConditions() {
        return discountConditions;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Money getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    //메서드 시그니처를 통해 할인 정책 정보 노출(캡슐화 위반) -> 할인 정책 변경 시 클라이언트 코드 변경
    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(discountAmount);
    }

    //메서드 시그니처를 통해 할인 정책 정보 노출(캡슐화 위반) -> 할인 정책 변경 시 클라이언트 코드 변경
    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee.minus(fee.times(discountPercent));
    }

    //메서드 시그니처를 통해 할인 정책 정보 노출(캡슐화 위반) -> 할인 정책 변경 시 클라이언트 코드 변경
    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw new IllegalArgumentException();
        }

        return fee;
    }

    //Movie와 DiscountCondition 간 결합도가 높은 부분
    //할인 정책의 명칭이 변경된다면 Movie 메서드 수정 필요
    //할인 정책이 추가되거나 삭제된다면, 해당 메서드의 if~else문 수정 필요
    //DiscountCondition의 할인 가능 여부 메서드 시그니쳐 변경이 있다면 해당 메서드의 클라이언트인 본 메서드 변경 필요
    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for (DiscountCondition condition : discountConditions) {
            if (condition.getType() == DiscountConditionType.PERIOD) {
                if (condition.isDiscountable(whenScreened.getDayOfWeek(),
                        whenScreened.toLocalTime())) {
                    return true;
                }
            } else {
                if (condition.isDiscountable(sequence)) {
                    return true;
                }
            }
        }

        return false;
    }
}
