package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class NightlyDiscountPhone extends AbstractPhone {

    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
//    private List<Call> calls = new ArrayList<>();
    private double taxRate;

//    public NightlyDiscountPhone(Money nightAmount, Money regularAmount, Duration seconds, double taxRate) {
//        this.nightlyAmount = nightAmount;
//        this.regularAmount = regularAmount;
//        this.seconds = seconds;
//        this.taxRate = taxRate;
//    }

//    public NightlyDiscountPhone(Money amount, Duration seconds, double taxRate,
//            Money nightlyAmount) {
//        super(amount, seconds, taxRate);
//        this.nightlyAmount = nightlyAmount;
//    }

    @Override
    protected Money calculateCallFee(Call call) {
        if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    return regularAmount.minus(nightlyAmount)
                            .times(call.getDuration().getSeconds() / seconds.getSeconds());
        } else {
            return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
        }
    }
}
