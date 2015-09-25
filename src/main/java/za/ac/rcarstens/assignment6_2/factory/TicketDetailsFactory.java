package za.ac.rcarstens.assignment6_2.factory;


import za.ac.rcarstens.assignment6_2.domain.TicketDetails;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
/**
 * Created by student on 2015/08/11.
 */
public class TicketDetailsFactory {
    public static TicketDetails createTicketDetails(
            double ticketPrice,
            String date,
            String ticketType)
    {

        TicketDetails TicketDetails = new TicketDetails
                .Builder(ticketPrice)
                .date(date)
                .ticketType(ticketType)
                .build();

        return TicketDetails;
    }
}
