package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/05.
 */
@Embeddable
public class FullName implements Serializable
{
    private String firstname;
    private String lastname;

    private FullName()
    {

    }

    public FullName(Builder builder)
    {
        this.firstname = builder.firstname;
        this.lastname = builder.lastname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public static class Builder
    {
        private String firstname;
        private String lastname;

        public Builder(String firstname)
        {
            this.firstname = firstname;
        }

        public Builder firstname(String firstname)
        {
            this.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname)
        {
            this.lastname = lastname;
            return this;
        }

        public Builder copy(FullName nameEmbedable)
        {
            this.firstname = nameEmbedable.firstname;
            this.lastname = nameEmbedable.lastname;
            return this;
        }

        public FullName build()
        {
            return new FullName(this);
        }
    }


}
