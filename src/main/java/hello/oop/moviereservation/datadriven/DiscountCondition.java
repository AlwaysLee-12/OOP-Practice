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

    public void setType(DiscountConditionType type) {
        this.type = type;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public DiscountConditionType getType() {
        return type;
    }

    public int getSequence() {
        return sequence;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
