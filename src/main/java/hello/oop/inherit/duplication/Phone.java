package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//중복 코드 수정 1. 하나의 클래스에 합치기(낮은 응집도와 높은 결합도. 타입 별 사용되지 않는 데이터 방치)
public class Phone {

    private static final int LATE_NIGHT_HOUR = 22;
    enum PhoneType {REGULAR, NIGHTLY}

    private PhoneType type;

    private Money amount;
    private Money nightAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(PhoneType type, Money amount, Money nightAmount, Money regularAmount,
            Duration seconds, double taxRate) {
        this.type = type;
        this.amount = amount;
        this.nightAmount = nightAmount;
        this.regularAmount = regularAmount;
        this.seconds = seconds;
        this.taxRate = taxRate;
    }

    public Phone(Money amount, Duration seconds, double taxRate) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds, taxRate);
    }

    public Phone(Money nightAmount, Money regularAmount, Duration seconds, double taxRate) {
        this(PhoneType.NIGHTLY, Money.ZERO, nightAmount, regularAmount, seconds, taxRate);
    }

    public void call(Call call) {
        calls.add(call);
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
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

        return result.plus(result.times(taxRate));
    }
}
