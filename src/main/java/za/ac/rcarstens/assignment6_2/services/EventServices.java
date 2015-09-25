package za.ac.rcarstens.assignment6_2.services;

import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
public interface EventServices {

    List<Ticket> getTickets(Long id);
    Event findById(Long id);
    List<Event> getAllEvents();
    Event findEventByIDandName(Long id, String email);
    Event save(Event entity);
    Event update(Event entity);
    void delete(Event entity);
    boolean exists(Long id);
}
