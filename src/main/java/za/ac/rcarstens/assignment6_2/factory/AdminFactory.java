package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Admin;
import za.ac.rcarstens.assignment6_2.domain.FullName;
import za.ac.rcarstens.assignment6_2.domain.Login;

/**
 * Created by student on 2015/08/07.
 */

public class AdminFactory {


    public static Admin createAdmin(Login loginDetails, FullName fullnameDetails)
    {
        Admin admin = new Admin
                .Builder(loginDetails)
                .FullNameDeats(fullnameDetails)
                .build();
        return admin;
    }
}
