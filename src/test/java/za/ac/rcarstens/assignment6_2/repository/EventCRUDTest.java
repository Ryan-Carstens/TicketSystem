package za.ac.rcarstens.assignment6_2.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.EventDetails;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.factory.EventDetailsFactory;
import za.ac.rcarstens.assignment6_2.factory.EventFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
//@SpringApplicationConfiguration(classes= App.class)
//@WebAppConfiguration
public class EventCRUDTest extends AbstractTestNGSpringContextTests {
    private Long id;

    @Autowired
    private EventRepository repository;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {

        List<Ticket> Tickets = new ArrayList<Ticket>();
        EventDetails EventDeats = EventDetailsFactory.createEventDetails("14 this road", "Party", "15 March", "1700");
        Event event = EventFactory
                .createEvent("Ryans 21st", EventDeats, Tickets);


        repository.save(event);
        id=event.getID();
        Assert.assertNotNull(event.getID());

    }

    //@Test(dependsOnMethods = "create")
    public void read() throws Exception {
        Event event = repository.findOne(id);
        Assert.assertNotNull(event);
    }

    //@Test(dependsOnMethods = "read")
    public void update() throws Exception {
        Event event = repository.findOne(id);

        List<Ticket> TicketsCopy = new ArrayList<Ticket>();
        EventDetails EventDeatsCopy = EventDetailsFactory.createEventDetails("14 this road", "Dinner", "15 March", "1700");
        Event newEvent = new Event.Builder("Ryans 21st").copy(event).eventDetails(EventDeatsCopy).Tickets(TicketsCopy).build();

        repository.save(newEvent);

        Event updatedEvent = repository.findOne(id);
        Assert.assertEquals(updatedEvent.getEventDetails().getEventType(),"Dinner");
    }

    //@Test(dependsOnMethods = "update")
    public void delete() throws Exception {
        Event event = repository.findOne(id);
        repository.delete(event);
        Event deletedEvent = repository.findOne(id);
        Assert.assertNull(deletedEvent);

    }
}
