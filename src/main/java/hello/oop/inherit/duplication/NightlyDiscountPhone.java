package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public NightlyDiscountPhone(Money nightAmount, Money regularAmount, Duration seconds, double taxRate) {
        this.nightAmount = nightAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
                );
            } else {
                result = result.plus(
                        regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
                );
            }
        }
        //요구사항이 추가되어 동일한 부분을 각각 다른 클래스에 대해 수정
        return result.plus(result.times(taxRate));
    }
}
