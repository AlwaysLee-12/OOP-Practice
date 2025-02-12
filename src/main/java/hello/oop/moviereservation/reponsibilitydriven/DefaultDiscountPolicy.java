package hello.oop.moviereservation.reponsibilitydriven;

import java.time.LocalDateTime;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy{

    private List<DiscountCondition> discountConditions;

    public DefaultDiscountPolicy(List<DiscountCondition> discountConditions) {
        this.discountConditions = discountConditions;
    }

    //서브 타입에 더 강력한 사전 조건이나 더 약한 사후 조건을 정의할 수 없다(클라이언트는 그 조건에 대해 알 수 없기 때문)
    //단, 슈퍼 타입과 같거나 더 약한 사전 조건이나 더 강한 사후 조건을 정의할 수는 있다(클라이언트 입장에서 영향이 없기 때문)
    public Money calculateDiscountAmount(Screening screening) {
        checkPrecondition(screening);

        Money amount = Money.ZERO ;
        for (DiscountCondition each : discountConditions
        ) {
            if (each.isSatisfiedBy(screening)) {
                amount = getDiscountAmount(screening);
                checkPostcondition(amount);
            }
        }

        amount = screening.getMovieFee();
        checkPostcondition(amount);
        return amount;
    }

    private void checkPostcondition(Money amount) {
        assert amount != null && amount.isGreaterThan(Money.ZERO);
    }

    private void checkPrecondition(Screening screening) {
        assert screening != null && screening.getWhenScreened().isAfter(LocalDateTime.now());
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
