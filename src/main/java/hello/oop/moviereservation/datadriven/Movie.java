package hello.oop.moviereservation.datadriven;

import java.time.Duration;
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

    public void setFee(Money fee) {
        this.fee = fee;
    }

    public void setDiscountConditions(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    public void setMovieType(MovieType movieType) {
        this.movieType = movieType;
    }

    public void setDiscountAmount(Money discountAmount) {
        this.discountAmount = discountAmount;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

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
}
