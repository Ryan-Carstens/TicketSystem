package za.ac.rcarstens.assignment6_2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.repository.EventRepository;
import za.ac.rcarstens.assignment6_2.services.EventServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
@Service
public class EventImpl implements EventServices  {
    @Autowired
    EventRepository repository;

    public Event findById(Long id) {
        return repository.findOne(id);
    }

    public List<Event> getAllEvents()
    {
        List<Event> AllEvents = new ArrayList<Event>();

        Iterable<Event> events = repository.findAll();
        for (Event event : events) {
            AllEvents.add(event);
        }
        return AllEvents;
    }

    public Event findEventByIDandName(Long id, String eventName)
    {
        Event event = repository.findOne(id);
        if(event != null)
        {
            if(event.getEventName().equals(eventName))
                return event;
        }

        return null;
    }

    public Event save(Event entity) {
        return repository.save(entity);
    }

    public Event update(Event entity) {
        return repository.save(entity);
    }

    public void delete(Event entity) {
        repository.delete(entity);

    }

    public boolean exists(Long id)
    {
        if(repository.findOne(id)!= null)
            return true;

        return false;
    }

    public List<Ticket> getTickets(Long id)
    {
        return repository.findOne(id).getTickets();
    }
}
