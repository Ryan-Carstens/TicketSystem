package za.ac.rcarstens.assignment6_2.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.rcarstens.assignment6_2.domain.Customer;
import za.ac.rcarstens.assignment6_2.domain.Ticket;
import za.ac.rcarstens.assignment6_2.repository.CustomerRepository;
import za.ac.rcarstens.assignment6_2.services.CustomerServices;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/24.
 */
@Service
public class CustomerImpl implements CustomerServices {
    
    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers()
    {
        List<Customer> AllCustomers = new ArrayList<Customer>();

        Iterable<Customer> customers = repository.findAll();
        for (Customer customer : customers) {
            AllCustomers.add(customer);
        }
        return AllCustomers;
    }

    public Customer findCustomerByIDandEmail(Long id, String loginEmail)
    {
        Customer customer = repository.findOne(id);
        if(customer != null)
        {
            if(customer.getLoginDeats().getLoginEmail().equals(loginEmail))
                return customer;
        }

        return null;
    }

    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    public void delete(Customer entity) {
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
