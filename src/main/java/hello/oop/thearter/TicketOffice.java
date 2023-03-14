package hello.oop.thearter;

import java.util.ArrayList;
import java.util.List;

public class TicketOffice {
    private Long amount;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketOffice(Long amount, List<Ticket> tickets) {
        this.amount = amount;
        this.tickets = tickets;
    }

    public void sellTicketTo(Audience audience) {
        //Audience와의 의존성이 생겨버림
        //trade-off: TicketOffice의 자율성이냐 낮은 결합도냐(Audience와의)
        //티켓 구매를 TicketSeller가 시킬거냐(주문 받고 매표소에서 꺼내서 줌) TicketOffice가 시킬거냐(TicketSeller가 Audience 매표소로 안내해줌. 매표소가 티켓 꺼내주고 계산 작업도 함)
        this.plusAmount(audience.buy(this.getTicket()));
    }

    private Ticket getTicket() {
        return tickets.remove(0);
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

    private void plusAmount(Long amount) {
        this.amount += amount;
    }
}
