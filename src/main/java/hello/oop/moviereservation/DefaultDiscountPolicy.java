package hello.oop.moviereservation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DefaultDiscountPolicy implements DiscountPolicy {
    //부모 클래스에서 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에 위임하는 TEMPLATE METHOD PATTERN
    //해당 클래스를 상속하는 자식 클래스는 해당 클래스의 인터페이스(수신할 수 있는 메세지)를 물려받는 것(구현을 재사용할 목적으로 설계하면 안 됨)
    //이를 통한 다형성 실현 -> 동일한 메세지를 수신했을 때 객체의 타입에 따라 다르게 응답할 수 있는 능력
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DefaultDiscountPolicy(DiscountCondition ...conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for (DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening screening);
}
