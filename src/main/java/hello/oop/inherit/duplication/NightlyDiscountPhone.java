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
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;
        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        getAmount().minus(nightlyAmount).times(call.getDuration().getSeconds() / getSeconds().getSeconds())
                );
            }
        }
        //요구사항이 추가되어 동일한 부분을 각각 다른 클래스에 대해 수정
        return result.minus(nightlyAmount.plus(nightlyFee.times(getTaxRate())));
    }
}
