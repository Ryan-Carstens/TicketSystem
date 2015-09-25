package za.ac.rcarstens.assignment6_2.domain;

import org.junit.Assert;
import za.ac.rcarstens.assignment6_2.factory.TicketDetailsFactory;
import za.ac.rcarstens.assignment6_2.factory.TicketFactory;

/**
 * Created by student on 2015/09/13.
 */
public class TicketTest {
    //@Test
    public void testCreate() throws Exception {
        TicketDetails ticketDeats = TicketDetailsFactory.createTicketDetails(8.90,"14 march","VIP");
        Ticket ticket = TicketFactory
                .createTicket(ticketDeats);
        Assert.assertEquals(8.90, ticket.getTicketDetails().getTicketPrice(),2);
    }

    //@Test
    public void testUpdate() throws Exception {
        TicketDetails ticketDeats = TicketDetailsFactory.createTicketDetails(8.90, "14 march", "VIP");
        Ticket ticket = TicketFactory
                .createTicket(ticketDeats);

        TicketDetails CopiedTicketDeats = TicketDetailsFactory.createTicketDetails(9.90, "14 march", "VIP");
        Ticket ticketCopy = new Ticket
                .Builder().copy(ticket).ticketDetails(CopiedTicketDeats).build();
        Assert.assertEquals("VIP", ticket.getTicketDetails().getTicketType());
        Assert.assertEquals("VIP", ticketCopy.getTicketDetails().getTicketType());
        Assert.assertEquals(8.90, ticket.getTicketDetails().getTicketPrice(),2);
        Assert.assertEquals(9.90, ticketCopy.getTicketDetails().getTicketPrice(),2);

    }
}
