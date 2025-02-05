package hello.oop.moviereservation.reponsibilitydriven;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class Factory {

    public Movie createAvatarMovie() {
        return new Movie(
                "아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(1000),
                        new PeriodCondition(
                                DayOfWeek.FRIDAY, LocalTime.of(1, 10), LocalTime.of(2, 10))));
    }
}
