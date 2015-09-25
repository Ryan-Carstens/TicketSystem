package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.EventDetails;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

import java.util.List;

/**
 * Created by student on 2015/05/21.
 */
public class EventFactory {
    public static Event createEvent(
            String eventName,
            EventDetails EventDeats,
            List<Ticket> tickets)

    {

        Event Event = new Event
                .Builder(eventName)
                .eventDetails(EventDeats)
                .Tickets(tickets)
                .build();
        return Event;
    }
}
