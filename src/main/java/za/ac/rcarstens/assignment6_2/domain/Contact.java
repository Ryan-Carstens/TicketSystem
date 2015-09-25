package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Embeddable
public class Contact implements Serializable{
    private String alternateEmail;
    private Long cellNumber;
    //Constructors
    private Contact()
    {

    }

    public Contact(Builder builder)
    {
        alternateEmail=builder.alternateEmail;
        cellNumber=builder.cellNumber;
    }

    // Get Methods
    public String getAlternateEmail() {
        return alternateEmail;
    }

    public Long getCellNumber() {
        return cellNumber;
    }

    //Builder Class
    public static class Builder
    {
        private String alternateEmail;
        private Long cellNumber;

        public Builder(String alternateEmail) {
            this.alternateEmail = alternateEmail;
        }

        public Builder cellNumber(Long value)
        {
            this.cellNumber=value;
            return this;
        }

        public Builder copy(Contact value)
        {
            this.cellNumber=value.cellNumber;
            this.alternateEmail=value.alternateEmail;
            return this;
        }

        public Contact build(){
            return new Contact(this);
        }
    }

}
