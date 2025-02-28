package hello.oop.moviereservation.reponsibilitydriven;

import java.time.LocalDateTime;

public class Screening {

    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
