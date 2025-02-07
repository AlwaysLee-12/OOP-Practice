package hello.oop.reuse.composition;

import hello.oop.moviereservation.reponsibilitydriven.Money;
import java.time.Duration;

public class CallMain {

    public static void main(String[] args) {
        Phone phone1 = new Phone(
                new TaxablePolicy(
                        new RegularPolicy(Money.wons(1000), Duration.ZERO),
                        0.05));

        Phone phone2 = new Phone(
                new RateDiscountablePolicy(
                        new RegularPolicy(Money.wons(1000), Duration.ZERO),
                        Money.wons(500)));
    }
}
