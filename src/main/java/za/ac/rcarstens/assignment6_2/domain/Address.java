package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by hashcode on 2015/04/20.
 */
@Embeddable
public class Address implements Serializable{
    private String postalAddress;
    private String physicalAddress;
    private int postalCode;

    //Constructors
    private Address()
    {

    }

    public Address(Builder builder) {
        postalAddress=builder.postalAddress;
        physicalAddress=builder.physicalAddress;
        postalCode=builder.postalCode;
    }

    //Get Methods
    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    //Builder Class
    public static class Builder
    {
        private String postalAddress;
        private String physicalAddress;
        private int postalCode;

        public Builder(String postalAddress)
        {
            this.postalAddress = postalAddress;
        }

        public Builder physicalAddress(String value)
        {
            this.physicalAddress = value;
            return this;
        }

        public Builder postalCode(int value)
        {
            this.postalCode = value;
            return this;
        }

        public Builder copy(Address value)
        {
            this.postalAddress=value.postalAddress;
            this.physicalAddress=value.physicalAddress;
            this.postalCode=value.postalCode;
            return this;
        }

        public Address build(){
            return new Address(this);
        }
    }

}
