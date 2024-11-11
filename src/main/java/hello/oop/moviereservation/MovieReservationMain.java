package hello.oop.moviereservation;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public class MovieReservationMain {

    public static void main(String[] args) {
        //코드의 의존성과 실행 시점의 의존성이 다름(컴파일 타임과 런타임의 의존성. 클래스 간 의존성과 객체 간 의존성)
        //컴파일 타임에는 인터페이스에 의존하고 런타임에 구체 클래스에 의존
        Movie avatar = new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new SequenceCondition(1),
                        new SequenceCondition(10),
                        new PeriodCondition(DayOfWeek.MONDAY, LocalTime.of(10, 0),
                                LocalTime.of(11, 59)),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0),
                                LocalTime.of(20, 59))));

        Movie titanic = new Movie("타이타닉",
                Duration.ofMinutes(180),
                Money.wons(11000),
                new AmountDiscountPolicy(
                        Money.wons(800),
                        new PeriodCondition(DayOfWeek.TUESDAY, LocalTime.of(14, 0),
                                LocalTime.of(16, 59)),
                        new SequenceCondition(2),
                        new PeriodCondition(DayOfWeek.THURSDAY, LocalTime.of(10, 0),
                                LocalTime.of(13, 59))));

        Movie starWars = new Movie("스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                new NoneDiscountPolicy());
    }
}
