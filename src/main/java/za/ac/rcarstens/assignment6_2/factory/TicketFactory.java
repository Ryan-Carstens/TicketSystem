package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.domain.TicketDetails;

/**
 * Created by student on 2015/05/21.
 */
public class TicketFactory {
    public static Ticket createTicket(TicketDetails TicketDeats){

        Ticket ticket = new Ticket
                .Builder()
                .ticketDetails(TicketDeats)
                .build();
        return ticket;
    }
}
