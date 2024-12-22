package hello.oop.moviereservation.datadriven;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {
    //할인 조건을 구현하는 데 필요한 데이터는 무엇인가?(데이터 중심 설계)
    private DiscountConditionType type;

    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }

    //메서드 시그니처를 통해 내부 데이터 정보 노출(캡슐화 위반) -> 내부 정보 변경 시 클라이언트 코드 변경
    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;
    }

    //메서드 시그니처를 통해 내부 데이터 정보 노출(캡슐화 위반) -> 내부 정보 변경 시 클라이언트 코드 변경
    public boolean isDiscountable(int sequence) {
        if (type != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }

        return this.sequence == sequence;
    }
}
