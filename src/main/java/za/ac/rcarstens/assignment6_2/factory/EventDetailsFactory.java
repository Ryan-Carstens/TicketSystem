package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.EventDetails;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

import java.util.List;

/**
 * Created by student on 2015/08/07.
 */
public class EventDetailsFactory {
    public static EventDetails createEventDetails(
            String eventAddress,
            String eventType,
            String eventDate,
            String eventTime)
    {

        EventDetails EventDetails = new EventDetails
                .Builder(eventAddress)
                .eventType(eventType)
                .eventDate(eventDate)
                .eventTime(eventTime)
                .build();

        return EventDetails;
    }
}
