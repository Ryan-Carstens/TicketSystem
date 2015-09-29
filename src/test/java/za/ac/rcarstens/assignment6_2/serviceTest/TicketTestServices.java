package za.ac.rcarstens.assignment6_2.serviceTest;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.domain.TicketDetails;
import za.ac.rcarstens.assignment6_2.factory.TicketDetailsFactory;
import za.ac.rcarstens.assignment6_2.factory.TicketFactory;
import za.ac.rcarstens.assignment6_2.services.implementation.TicketImpl;

/**
 * Created by student on 2015/09/23.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class TicketTestServices extends AbstractTestNGSpringContextTests {

    private Long id;

    @Autowired
    private TicketImpl service;

    //@Test
    public void create() throws Exception {

        TicketDetails ticketDeats = TicketDetailsFactory.createTicketDetails(8.90, "14 march", "VIP");
        Ticket ticket = TicketFactory
                .createTicket(ticketDeats);

        service.save(ticket);
        id=ticket.getTicketID();
        Assert.assertNotNull(ticket.getTicketID());

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Ticket ticket = service.findById(id);
        Assert.assertNotNull(ticket);
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Ticket ticket = service.findById(id);

        TicketDetails CopiedTicketDeats = TicketDetailsFactory.createTicketDetails(9.90, "14 march", "VIP");
        Ticket newMyTicket = new Ticket
                .Builder()
                .copy(ticket).ticketDetails(CopiedTicketDeats).build();
        service.save(newMyTicket);

        Ticket updatedTicket = service.findById(id);
        Assert.assertEquals(updatedTicket.getTicketDetails().getTicketType(),"VIP");
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Ticket ticket = service.findById(id);
        service.delete(ticket);
        Ticket deletedTicket = service.findById(id);
        Assert.assertNull(deletedTicket);
    }



}
