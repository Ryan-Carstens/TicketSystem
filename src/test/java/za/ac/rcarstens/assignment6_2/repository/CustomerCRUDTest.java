package za.ac.rcarstens.assignment6_2.repository;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.rcarstens.assignment6_2.App;
import za.ac.rcarstens.assignment6_2.domain.*;
import za.ac.rcarstens.assignment6_2.factory.*;

import java.util.ArrayList;
import java.util.List;

@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CustomerCRUDTest extends AbstractTestNGSpringContextTests {
    private Long id;


    @Autowired
    private CustomerRepository repository;

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void create() throws Exception {

        List<Ticket> Tickets = new ArrayList<Ticket>();
        Login LoginDeats = LoginFactory.createLogin("lance@gmail.com", "pass");
        FullName FullNameDeats = FullNameFactory.createFullName("Lance", "Coe");
        Address AddressDeats = AddressFactory.createAddress("4 lance road", "4 lance road", 7975);
        Contact ContactDeats = ContactFactory.createContact("lance@yahoo.com", 823456789l);
        Bank BankDeats = BankFactory.createBank("ABSA", "Cheque", 7800679080l, 6950);

        Customer customer = CustomerFactory
                .createCustomer(LoginDeats, FullNameDeats, ContactDeats, AddressDeats, BankDeats, Tickets);

        repository.save(customer);
        id=customer.getID();
        Assert.assertNotNull(customer.getID());

    }

    @Test(dependsOnMethods = "create")
    public void read() throws Exception {
       Customer customer = repository.findOne(id);
        Assert.assertNotNull(customer);
    }

    @Test(dependsOnMethods = "read")
    public void update() throws Exception {
       Customer customer = repository.findOne(id);

        List<Ticket> TicketsCopy = new ArrayList<Ticket>();
        Login LoginDeatsCopy = LoginFactory.createLogin("lance@gmail.com", "pass");
        FullName FullNameDeatsCopy = FullNameFactory.createFullName("Lance2", "Coe");
        Address AddressDeatsCopy = AddressFactory.createAddress("4 lance road", "4 lance road", 7975);
        Contact ContactDeatsCopy = ContactFactory.createContact("lance@yahoo.com", 823456789l);
        Bank BankDeatsCopy = BankFactory.createBank("ABSA", "Cheque", 7800679090l, 6950);

        Customer newCustomer = new Customer.Builder(LoginDeatsCopy).copy(customer).FullNameDeats(FullNameDeatsCopy).AddressDeats(AddressDeatsCopy).ContactDeats(ContactDeatsCopy).BankDeats(BankDeatsCopy).Tickets(TicketsCopy).build();

        repository.save(newCustomer);

       Customer updatedCustomer = repository.findOne(id);
        Assert.assertEquals(updatedCustomer.getFullNameDeats().getFirstname(),"Lance2");
    }

    @Test(dependsOnMethods = "update")
    public void delete() throws Exception {
       Customer customer = repository.findOne(id);
        repository.delete(customer);
       Customer deletedCustomer = repository.findOne(id);
        Assert.assertNull(deletedCustomer);

    }
}
