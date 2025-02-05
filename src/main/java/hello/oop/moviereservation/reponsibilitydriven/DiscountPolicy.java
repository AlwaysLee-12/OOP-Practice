package hello.oop.moviereservation.reponsibilitydriven;

public interface DiscountPolicy {

    Money calculateDiscountAmount(Screening screening);
}
