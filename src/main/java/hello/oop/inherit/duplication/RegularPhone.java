package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

//중복 코드 수정 1. 하나의 클래스에 합치기(낮은 응집도와 높은 결합도. 타입 별 사용되지 않는 데이터 방치)
//2. 상속을 이용한 중복 코드 제거(부모 코드와 강결합, 세금 부과 요구사항 추가 시 중복 코드에 대해 같은 부분 중복 변경 필요)
//3. 상속 구조에서의 결합도 완화(1. 차이점을 메서드로 추출, 자식 클래스의 추상적인 메서드를 부모 클래스로 승격)
public class RegularPhone extends Phone {

//    private static final int LATE_NIGHT_HOUR = 22;
//    enum PhoneType {REGULAR, NIGHTLY}

//    private PhoneType type;

    private Money amount;
//    private Money nightAmount;
//    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
//    private double taxRate;

    public RegularPhone(Money amount, Duration seconds) {
        this.amount = amount;
        this.seconds = seconds;
    }

    //    public Phone(PhoneType type, Money amount, Money nightAmount, Money regularAmount,
//            Duration seconds, double taxRate) {
//        this.type = type;
//        this.amount = amount;
//        this.nightAmount = nightAmount;
//        this.regularAmount = regularAmount;
//        this.seconds = seconds;
//        this.taxRate = taxRate;
//    }

//    public Phone(Money amount, Duration seconds, double taxRate) {
//        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds, taxRate);
//    }
//
//    public Phone(Money nightAmount, Money regularAmount, Duration seconds, double taxRate) {
//        this(PhoneType.NIGHTLY, Money.ZERO, nightAmount, regularAmount, seconds, taxRate);
//    }

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

//    public double getTaxRate() {
//        return taxRate;
//    }

    @Override
    protected Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
