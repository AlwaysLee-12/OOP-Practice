package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone extends Phone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
//    private Money regularAmount;
//    private Duration seconds;
//    private List<Call> calls = new ArrayList<>();
//    private double taxRate;

//    public NightlyDiscountPhone(Money nightAmount, Money regularAmount, Duration seconds, double taxRate) {
//        this.nightlyAmount = nightAmount;
//        this.regularAmount = regularAmount;
//        this.seconds = seconds;
//        this.taxRate = taxRate;
//    }


    public NightlyDiscountPhone(Money amount, Duration seconds, double taxRate,
            Money nightlyAmount) {
        super(amount, seconds, taxRate);
        this.nightlyAmount = nightlyAmount;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : getCalls()) {
            result = result.plus(calculateCallFee(call));
        }
        //요구사항이 추가되어 동일한 부분을 각각 다른 클래스에 대해 수정
        return result;
    }

    private Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    return getAmount().minus(nightlyAmount)
                            .times(call.getDuration().getSeconds() / getSeconds().getSeconds());
        } else {
            return getAmount().times(call.getDuration().getSeconds() / getSeconds().getSeconds());
        }
    }
}
