package hello.oop.thearter;

//Theater가 너무 많은 일을 하고 있지 않나?
//관람객 가방에서 초대장 확인, 판매원을 움직여 매표소에서 티켓 불출, 관람객 가방에 티켓 넣어주고 돈 빼고 판매원을 움직여 매표소에 돈 넣고
//동작은 하지만, 변경이 용이하지 않고(관람객이 가방을 들고있지 않고, 티켓을 매표소 밖에서 판다면?), 이해하기 어려움(상식적이지 않음, 한 클래스에서 많은 일을 해 세부사항을 기억해야 함)
//Theater가 각 객체를 너무 많이 알고 있음(해당 객체를 변경하면 Theater도 변경해야 함) => 최소한의 의존성만 남기고 불필요한 의존성은 제거하자
//1. 자율성 높이기(각 객체의 동작을 Theater가 맘대로 시키지 못하도록 막자)
public class Theater {
    private TicketSeller ticketSeller;

    public Theater(TicketSeller ticketSeller) {
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience) {
//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().setTicket(ticket);
//        }else{
//            Ticket ticket = ticketSeller.getTicketOffice().getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketSeller.getTicketOffice().plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }
        //TicketSeller의 인터페이스에만 의존(TicketSeller의 의존 관계에 대해서 모름)
        ticketSeller.sellTo(audience);
    }
}
