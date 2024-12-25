package hello.oop.moviereservation.reponsibilitydriven;

import hello.oop.moviereservation.Money;
import hello.oop.moviereservation.Screening;

public class Reservation {

    private Customer customer;
    private hello.oop.moviereservation.Screening screening;
    private hello.oop.moviereservation.Money fee;
    private int audienceCount;

    public Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.screening = screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
