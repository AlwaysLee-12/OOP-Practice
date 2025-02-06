package hello.oop.inherit.duplication;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;
import java.time.LocalDateTime;

public class CallMain {

    public static void main(String[] args) {
        Phone phone = new RegularPhone(Money.wons(5), Duration.ofSeconds(10), 0.1);

        phone.calculateFee();
    }
}
