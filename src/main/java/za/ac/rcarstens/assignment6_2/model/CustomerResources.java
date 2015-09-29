package za.ac.rcarstens.assignment6_2.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.rcarstens.assignment6_2.domain.*;
import java.util.List;


/**
 * Created by student on 2015/04/28.
 */

public class CustomerResources extends ResourceSupport implements UserInterface {
    
    private Long resID;
    private Login LoginDeats;
    private FullName FullNameDeats;
    private Contact ContactDeats;
    private Address AddressDeats;
    private Bank BankDeats;
    private List<Ticket> Tickets;

    //Constructors
    private CustomerResources() {

    }

    public CustomerResources(Builder builder){
        this.resID=builder.resID;
        this.LoginDeats=builder.LoginDeats;
        this.FullNameDeats=builder.FullNameDeats;
        this.ContactDeats=builder.ContactDeats;
        this.AddressDeats=builder.AddressDeats;
        this.BankDeats=builder.BankDeats;
        this.Tickets=builder.Tickets;

    }


    //Get Methods
    public Long getID() {
        return resID;
    }

    public Login getLoginDeats()
    {
        return LoginDeats;
    }

    public FullName getFullNameDeats()
    {
        return FullNameDeats;
    }

    public Contact getContactDeats() {
        return ContactDeats;
    }

    public Address getAddressDeats() {
        return AddressDeats;
    }

    public Bank getBankDeats() {
        return BankDeats;
    }

    public List<Ticket> getTickets() {
        return Tickets;
    }


    //Builder Subclass
    public static class Builder{
        private Long resID;
        private Login LoginDeats;
        private FullName FullNameDeats;
        private Contact ContactDeats;
        private Address AddressDeats;
        private Bank BankDeats;
        private List<Ticket> Tickets;

        public Builder(Login value) {
            this.LoginDeats = value;
        }

        public Builder resID(Long value){
            this.resID=value;
            return this;
        }

        public Builder FullNameDeats(FullName value){
            this.FullNameDeats=value;
            return this;
        }

        public Builder ContactDeats(Contact value){
            this.ContactDeats=value;
            return this;
        }

        public Builder AddressDeats(Address value){
            this.AddressDeats=value;
            return this;
        }

        public Builder BankDeats(Bank value){
            this.BankDeats=value;
            return this;
        }

        public Builder Tickets(List<Ticket> value){
            this.Tickets=value;
            return this;
        }

        public Builder copy(CustomerResources value){
            this.resID=value.resID;
            this.LoginDeats=value.LoginDeats;
            this.FullNameDeats=value.FullNameDeats;
            this.ContactDeats=value.ContactDeats;
            this.AddressDeats=value.AddressDeats;
            this.BankDeats=value.BankDeats;
            this.Tickets=value.Tickets;

            return this;
        }

        public CustomerResources build(){
            return new CustomerResources(this);
        }
    }

}
