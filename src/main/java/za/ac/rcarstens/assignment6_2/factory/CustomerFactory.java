package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.*;

import java.util.List;
import java.util.Map;

/**
 * Created by hashcode on 2015/04/23.
 */
public class CustomerFactory {

    public static Customer createCustomer(
            Login LoginDeats,
            FullName FullNameDeats,
            Contact ContactDeats,
            Address AddressDeats,
            Bank BankDeats,
            List<Ticket> tickets){

        Customer Customer = new Customer
                .Builder(LoginDeats)
                .FullNameDeats(FullNameDeats)
                .ContactDeats(ContactDeats)
                .AddressDeats(AddressDeats)
                .BankDeats(BankDeats)
                .Tickets(tickets)
                .build();
        return Customer;
    }
}
