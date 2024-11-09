package hello.oop.moviereservation;

import java.time.LocalDateTime;

public class Screening {
    //인터페이스(기능)와 구현(상태)의 분리
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Movie getMovie() {
        return movie;
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        //메세지(요청 시그니쳐)와 메서드(수신 동작)의 구분
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public Money getMovieFee() {
        return movie.getFee();
    }
}
