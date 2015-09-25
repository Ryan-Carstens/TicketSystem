package za.ac.rcarstens.assignment6_2.factory;

import za.ac.rcarstens.assignment6_2.domain.Login;

/**
 * Created by student on 2015/08/07.
 */
public class LoginFactory {
    public static Login createLogin(
            String loginEmail,
            String password)
    {

        Login Login = new Login
                .Builder(loginEmail)
                .password(password)
                .build();

        return Login;
    }
}
