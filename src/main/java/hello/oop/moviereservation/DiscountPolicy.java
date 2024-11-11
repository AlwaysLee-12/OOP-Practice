package hello.oop.moviereservation;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
