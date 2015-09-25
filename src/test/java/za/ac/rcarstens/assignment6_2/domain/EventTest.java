package za.ac.rcarstens.assignment6_2.domain;

import org.junit.Assert;
import za.ac.rcarstens.assignment6_2.factory.EventDetailsFactory;
import za.ac.rcarstens.assignment6_2.factory.EventFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class EventTest {
    //@Test
    public void testCreate() throws Exception {
        List<Ticket> Tickets = new ArrayList<Ticket>();
        EventDetails EventDeats = EventDetailsFactory.createEventDetails("14 that road", "Party", "14 March", "1700");
        Event event = EventFactory
                .createEvent("Lances 21st", EventDeats, Tickets);
        Assert.assertEquals("Lances 21st", event.getEventName());
        Assert.assertEquals("Party", event.getEventDetails().getEventType());
    }

    //@Test
    public void testUpdate() throws Exception {
        List<Ticket> Tickets = new ArrayList<Ticket>();
        EventDetails EventDeats = EventDetailsFactory.createEventDetails("14 that road", "Party", "14 March", "1700");
        Event event = EventFactory
                .createEvent("Lances 21st", EventDeats, Tickets);

        List<Ticket> TicketsCopy = new ArrayList<Ticket>();
        EventDetails EventDeatsCopy = EventDetailsFactory.createEventDetails("14 that road", "Dinner", "14 March", "1700");
        Event eventCopy = new Event.Builder("Lances 21st").copy(event).eventDetails(EventDeatsCopy).Tickets(TicketsCopy).build();

        Assert.assertEquals("Lances 21st", event.getEventName());
        Assert.assertEquals("Lances 21st", eventCopy.getEventName());

        Assert.assertEquals("Party", event.getEventDetails().getEventType());
        Assert.assertEquals("Dinner", eventCopy.getEventDetails().getEventType());
    }
}
