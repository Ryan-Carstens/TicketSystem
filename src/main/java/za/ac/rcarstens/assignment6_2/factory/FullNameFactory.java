package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.FullName;

/**
 * Created by student on 2015/08/07.
 */
public class FullNameFactory {
    public static FullName createFullName(
            String fullName,
            String lastName)
    {

        FullName FullName = new FullName
                .Builder(fullName)
                .lastname(lastName)
                .build();

        return FullName;
    }
}
