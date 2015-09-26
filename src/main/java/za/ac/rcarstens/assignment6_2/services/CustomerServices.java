package za.ac.rcarstens.assignment6_2.services;

import za.ac.rcarstens.assignment6_2.domain.Customer;
import za.ac.rcarstens.assignment6_2.domain.Ticket;

import java.util.List;

/**
 * Created by student on 2015/09/23.
 */
public interface CustomerServices  {

    List<Ticket> getTickets(Long id);
    List<Customer> getAllCustomers();
    Customer findById(Long id);
    boolean findCustomerByEmailandPassword(String loginEmail, String password);
    Customer save(Customer entity);
    Customer update(Customer entity);
    void delete(Customer entity);
    boolean exists(Long id);

}
