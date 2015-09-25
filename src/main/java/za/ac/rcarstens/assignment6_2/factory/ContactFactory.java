package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Contact;

/**
 * Created by student on 2015/05/21.
 */
public class ContactFactory {
    public static Contact createContact(
            String alternateEmail,
            Long cellNumber){

        Contact Contact = new Contact
                .Builder(alternateEmail)
                .cellNumber(cellNumber)
                .build();
        return Contact;
    }
}
