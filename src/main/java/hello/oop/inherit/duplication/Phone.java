package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.util.ArrayList;
import java.util.List;

//현재 상속 구조에서 부가 정책으로 세금부과나 금액 할인 정책을 추가 하려고 하면 각 phone에 대해 부가 정책 가지 수만큼 클래스 폭발을 일으킨다
public abstract class Phone {

    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }
        //요구사항이 추가되어 동일한 부분을 각각 다른 클래스에 대해 수정
        return result;
    }

    protected Money afterCalculated(Money fee) {
        return fee;
    }

    abstract protected Money calculateCallFee(Call call);
}
