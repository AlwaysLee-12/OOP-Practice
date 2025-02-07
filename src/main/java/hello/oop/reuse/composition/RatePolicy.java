package hello.oop.reuse.composition;

import hello.oop.moviereservation.reponsibilitydriven.Money;

public interface RatePolicy {

    Money calculateFee(Phone phone);
}
