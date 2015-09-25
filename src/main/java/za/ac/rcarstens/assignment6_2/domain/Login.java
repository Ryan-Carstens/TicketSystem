package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/05.
 */
@Embeddable
public class Login implements Serializable
{
    @Column(unique = true)
    private String loginEmail;
    private String password;

    //Constructors
    private Login()
    {

    }

    public Login(Builder builder)
    {
        this.loginEmail = builder.loginEmail;
        this.password = builder.password;
    }

    //Get Methods
    public String getLoginEmail()
    {
        return loginEmail;
    }

    public String getPassword()
    {
        return password;
    }

    public static class Builder
    {
        private String loginEmail;
        private String password;

        public Builder(String loginEmail)
        {
            this.loginEmail = loginEmail;
        }

        public Builder password(String password)
        {
            this.password = password;
            return this;
        }

        public Builder copy(Login login)
        {
            this.loginEmail = login.loginEmail;
            this.password = login.password;
            return this;
        }

        public Login build()
        {
            return new Login(this);
        }
    }

}
