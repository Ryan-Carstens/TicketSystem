package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Address;

/**
 * Created by student on 2015/05/21.
 */
public class AddressFactory {
    public static Address createAddress(
            String postalAddress,
            String physicalAddress,
            int postalCode)
    {

        Address Address = new Address
                .Builder(postalAddress)
                .physicalAddress(physicalAddress)
                .postalCode(postalCode)
                .build();

        return Address;
    }
}
