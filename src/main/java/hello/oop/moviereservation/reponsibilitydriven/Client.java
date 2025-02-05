package hello.oop.moviereservation.reponsibilitydriven;

public class Client {

    private Factory factory;

    public Money getAvatarGee() {
        Movie avatar = factory.createAvatarMovie();

        return avatar.getFee();
    }
}
