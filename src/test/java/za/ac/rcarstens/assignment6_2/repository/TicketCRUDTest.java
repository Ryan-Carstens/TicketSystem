package za.ac.rcarstens.assignment6_2.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.domain.TicketDetails;
import za.ac.rcarstens.assignment6_2.factory.TicketDetailsFactory;
import za.ac.rcarstens.assignment6_2.factory.TicketFactory;

/**
 * Created by student on 2015/09/15.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class TicketCRUDTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private TicketRepository repository;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {

        TicketDetails ticketDeats = TicketDetailsFactory.createTicketDetails(8.90, "14 march", "VIP");
        Ticket ticket = TicketFactory
                .createTicket(ticketDeats);

        repository.save(ticket);
        id=ticket.getTicketID();
        Assert.assertNotNull(ticket.getTicketID());

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Ticket ticket = repository.findOne(id);
        Assert.assertNotNull(ticket);
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Ticket ticket = repository.findOne(id);

        TicketDetails CopiedTicketDeats = TicketDetailsFactory.createTicketDetails(9.90, "14 march", "VIP");
        Ticket newMyTicket = new Ticket
                .Builder()
                .copy(ticket).ticketDetails(CopiedTicketDeats).build();
        repository.save(newMyTicket);

        Ticket updatedTicket = repository.findOne(id);
        Assert.assertEquals(updatedTicket.getTicketDetails().getTicketType(),"VIP");
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Ticket ticket = repository.findOne(id);
        repository.delete(ticket);
        Ticket deletedTicket = repository.findOne(id);
        Assert.assertNull(deletedTicket);
    }

}
