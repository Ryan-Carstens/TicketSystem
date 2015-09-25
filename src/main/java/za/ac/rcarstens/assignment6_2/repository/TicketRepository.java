package za.ac.rcarstens.assignment6_2.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

/**
 * Created by student on 2015/08/12.
 */
public interface TicketRepository extends CrudRepository<Ticket, Long> {
}