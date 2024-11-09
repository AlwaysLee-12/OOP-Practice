package hello.oop.moviereservation;

public interface DiscountCondition {

    boolean isSatisfiedBy(Screening screening);
}
