package za.ac.rcarstens.assignment6_2.services;

import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
public interface EventServices extends Services<Event, Long>{

    List<Ticket> getTickets(Long id);
}
