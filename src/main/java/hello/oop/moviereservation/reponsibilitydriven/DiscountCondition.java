package hello.oop.moviereservation.reponsibilitydriven;

import static hello.oop.moviereservation.reponsibilitydriven.DiscountConditionType.PERIOD;

import java.time.DayOfWeek;
import java.time.LocalTime;

//낮은 응집도 - 변경의 이유가 세 가지(정책 추가 시, 기간 조건 변경 시, 순번 조건 변경
//높은 응집도를 위해 우선 초기화 시점이 다른 속성들을 분리하자
//높은 응집도를 위해 메서드들과 그 메서드가 사용하는 인스턴스 변수를 묶어 분리하자
//할인 조건 타입에 따라 클래스를 분리하자
//본 클래스는 분리한 클래스를 묶는 역할 정의 클래스로 전환하자(역할은 대체 가능성이며 movie 입장에서 보면 관련 클래스는 모두 같은 책임이자 역할을 수행) -> 객체의 구체적인 타입 추상화 가능
// => Polymophism 패턴(타입에 따라 변하는 로직이 있을 때, 타입을 추상화하고 각 타입에 맞는 책임을 할당하라)
// => Protected Variations 패턴(변경 가능성이 높은 것을 캡슐화 하라. 본 클래스에서 각 타입을 캡슐화하고 타입 추가되거나 변경되어도 클라이언트 변경 없음)
public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
//
//    private DiscountConditionType type;
//    private int sequence;
//    private DayOfWeek dayOfWeek;
//    private LocalTime startTime;
//    private LocalTime endTime;
//
//    public boolean isSatisfiedBy(Screening screening) {
//        if (PERIOD.equals(type)) {
//            return isSatisfiedByPeriod(screening);
//        }
//
//        return isSatisfiedBySequence(screening);
//    }

//    private boolean isSatisfiedByPeriod(Screening screening) {
//        return dayOfWeek.equals(screening.getWhenScreened().getDayOfWeek()) &&
//                !startTime.isAfter(screening.getWhenScreened().toLocalTime()) &&
//                !endTime.isBefore(screening.getWhenScreened().toLocalTime());
//    }
//
//    private boolean isSatisfiedBySequence(Screening screening) {
//        return sequence == screening.getSequence();
//    }
}
