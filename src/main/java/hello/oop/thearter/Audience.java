package hello.oop.thearter;

public class Audience {
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket) {
        //Bag도 자율적인 존재로 만들어보자
//        if (bag.hasInvitation()) {
//            bag.setTicket(ticket);
//
//            return 0L;
//        }else{
//            bag.minusAmount(ticket.getFee());
//            bag.setTicket(ticket);
//
//            return ticket.getFee();
//        }
        return bag.hold(ticket);
    }
}
