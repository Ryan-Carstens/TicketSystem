package za.ac.rcarstens.assignment6_2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.repository.EventRepository;
import za.ac.rcarstens.assignment6_2.services.EventServices;
import za.ac.rcarstens.assignment6_2.services.Services;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
@Service
public class EventImpl implements EventServices  {
    @Autowired
    EventRepository repository;

    public List<Event> getAllEvents()
    {
        List<Event> AllEvents = new ArrayList<Event>();

        Iterable<Event> customers = repository.findAll();
        for (Event customer : customers) {
            AllEvents.add(customer);
        }
        return AllEvents;
    }

    public Event findEventByIDandEmail(Long id, String eventName)
    {
        Event customer = repository.findOne(id);
        if(customer != null)
        {
            if(customer.getLoginDeats().getLoginEmail().equals(loginEmail))
                return customer;
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
