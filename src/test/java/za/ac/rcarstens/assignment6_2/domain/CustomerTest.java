package za.ac.rcarstens.assignment6_2.domain;

import org.junit.Assert;
import za.ac.rcarstens.assignment6_2.factory.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/13.
 */
public class CustomerTest {
    //@Test
    public void testCreate() throws Exception {
        List<Ticket> Tickets = new ArrayList<Ticket>();
        Login LoginDeats = LoginFactory.createLogin("lance@gmail.com", "pass");
        FullName FullNameDeats = FullNameFactory.createFullName("Lance", "Coe");
        Address AddressDeats = AddressFactory.createAddress("4 lance road", "4 lance road", 7975);
        Contact ContactDeats = ContactFactory.createContact("lance@yahoo.com", 823456789l);
        Bank BankDeats = BankFactory.createBank("ABSA", "Cheque", 7800679080l, 6950);

        Customer customer = CustomerFactory
                .createCustomer(LoginDeats, FullNameDeats, ContactDeats, AddressDeats, BankDeats, Tickets);
        Assert.assertEquals("lance@yahoo.com", customer.getContactDeats().getAlternateEmail());
        Assert.assertEquals("Lance", customer.getFullNameDeats().getFirstname());
    }

    //@Test
    public void testUpdate() throws Exception {
        List<Ticket> Tickets = new ArrayList<Ticket>();
        Login LoginDeats = LoginFactory.createLogin("lance@gmail.com", "pass");
        FullName FullNameDeats = FullNameFactory.createFullName("Lance", "Coe");
        Address AddressDeats = AddressFactory.createAddress("4 lance road", "4 lance road", 7975);
        Contact ContactDeats = ContactFactory.createContact("lance@yahoo.com", 823456789l);
        Bank BankDeats = BankFactory.createBank("ABSA", "Cheque", 7800679080l, 6950);

        Customer customer = CustomerFactory
                .createCustomer(LoginDeats,FullNameDeats,ContactDeats,AddressDeats,BankDeats,Tickets);

        List<Ticket> TicketsCopy = new ArrayList<Ticket>();
        Login LoginDeatsCopy = LoginFactory.createLogin("lance@gmail.com", "pass");
        FullName FullNameDeatsCopy = FullNameFactory.createFullName("Lance", "Coe");
        Address AddressDeatsCopy = AddressFactory.createAddress("4 lance road", "4 lance road", 7975);
        Contact ContactDeatsCopy = ContactFactory.createContact("lance@yahoo.com", 823456789l);
        Bank BankDeatsCopy = BankFactory.createBank("ABSA", "Cheque", 7800679090l, 6950);

        Customer customerCopy = new Customer.Builder(LoginDeatsCopy).copy(customer).FullNameDeats(FullNameDeatsCopy).AddressDeats(AddressDeatsCopy).ContactDeats(ContactDeatsCopy).BankDeats(BankDeatsCopy).Tickets(TicketsCopy).build();

        Assert.assertEquals("lance@gmail.com", customer.getLoginDeats().getLoginEmail());
        Assert.assertEquals("lance@gmail.com", customerCopy.getLoginDeats().getLoginEmail());

        Assert.assertEquals(7800679080l, customer.getBankDeats().getAccNumber(),0);
        Assert.assertEquals(7800679090l, customerCopy.getBankDeats().getAccNumber(),0);
    }
}
