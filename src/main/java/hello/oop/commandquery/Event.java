package hello.oop.commandquery;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {

    private String subject;
    private LocalDateTime from;
    private Duration duration;

    public Event(String subject, LocalDateTime from, Duration duration) {
        this.subject = subject;
        this.from = from;
        this.duration = duration;
    }

    //쿼리의 의도를 띄고 있지만, 상태를 변경하는 명령의 성격도 가지고 있어 이해하기 어렵고 잘못 사용하기 쉬우며, 버그를 양산할 수 있다
    //명령과 쿼리를 명확하게 분리한다
    public boolean isSatisfied(RecurringSchedule schedule) {
        if (from.getDayOfWeek() != schedule.getDayOfWeek() ||
        !from.toLocalTime().equals(schedule.getFrom()) ||
        !duration.equals(schedule.getDuration())) {
//            reschedule(schedule);

            return false;
        }

        return true;
    }

    public void reschedule(RecurringSchedule schedule) {
        from = LocalDateTime.of(from.toLocalDate().plusDays(dayDistance(schedule)),
                schedule.getFrom());
        duration = schedule.getDuration();
    }

    private long dayDistance(RecurringSchedule schedule) {
        return schedule.getDayOfWeek().getValue() - from.getDayOfWeek().getValue();
    }
}
