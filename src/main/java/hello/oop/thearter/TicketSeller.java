package hello.oop.thearter;

public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice) {
        this.ticketOffice = ticketOffice;
    }

    //Theater가 TicketOffice까지 건들지 못하게 막자
//    public TicketOffice getTicketOffice() {
//        return ticketOffice;
//    }

    public void sellTo(Audience audience) {
        //TicketSeller도 마찬가지로 Audience에 대해 너무 많이 알고 있음(의존 관계까지)
        //Audience의 Bag 캡슐화 해주기
//        if (audience.getBag().hasInvitation()) {
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().setTicket(ticket);
//        }else{
//            Ticket ticket = ticketOffice.getTicket();
//            audience.getBag().minusAmount(ticket.getFee());
//            ticketOffice.plusAmount(ticket.getFee());
//            audience.getBag().setTicket(ticket);
//        }
        //TicketSeller와 Audience 사이 결합도 낮아짐 -> Audience 수정이 TicketSeller에 영향을 미치지 않음
        //메세지를 통한 상호작용
//        ticketOffice.plusAmount(audience.buy(ticketOffice.getTicket()));

        //TiketOffice도 자율적인 존재로 만들어주자
        ticketOffice.sellTicketTo(audience);
    }
}
