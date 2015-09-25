package za.ac.rcarstens.assignment6_2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.repository.TicketRepository;
import za.ac.rcarstens.assignment6_2.services.TicketServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
@Service
public class TicketImpl implements TicketServices {



    @Autowired
    private TicketRepository repository;
    @Override
    public Ticket findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Ticket save(Ticket entity) {
        return repository.save(entity);
    }

    @Override
    public Ticket update(Ticket entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Ticket entity) {
        repository.delete(entity);

    }

    @Override
    public List<Ticket> findAll() {
        List<Ticket> allTickets = new ArrayList<>();
        Iterable<Ticket> tickets = repository.findAll();
        for (Ticket ticket : tickets) {
            allTickets.add(ticket);
        }
        return allTickets;
    }
}
