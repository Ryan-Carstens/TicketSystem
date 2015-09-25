package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by student on 2015/04/28.
 */
@Entity
public class Customer implements Serializable, UserInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private Login LoginDeats;
    @Embedded
    private FullName FullNameDeats;
    @Embedded
    private Contact ContactDeats;
    @Embedded
    private Address AddressDeats;
    @Embedded
    private Bank BankDeats;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Ticket_id")
    private List<Ticket> Tickets;

    //Constructors
    private Customer() {

    }

    public Customer(Builder builder){
        this.id=builder.id;
        this.LoginDeats=builder.LoginDeats;
        this.FullNameDeats=builder.FullNameDeats;
        this.ContactDeats=builder.ContactDeats;
        this.AddressDeats=builder.AddressDeats;
        this.BankDeats=builder.BankDeats;
        this.Tickets=builder.Tickets;

    }


    //Get Methods
    public Long getID() {
        return id;
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
        private Long id;
        private Login LoginDeats;
        private FullName FullNameDeats;
        private Contact ContactDeats;
        private Address AddressDeats;
        private Bank BankDeats;
        private List<Ticket> Tickets;

        public Builder(Login value) {
            this.LoginDeats = value;
        }

        public Builder id(Long value){
            this.id=value;
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

        public Builder copy(Customer value){
            this.id=value.id;
            this.LoginDeats=value.LoginDeats;
            this.FullNameDeats=value.FullNameDeats;
            this.ContactDeats=value.ContactDeats;
            this.AddressDeats=value.AddressDeats;
            this.BankDeats=value.BankDeats;
            this.Tickets=value.Tickets;

            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Customer_id='" + id + '\'' +
                ", LoginDetails=" + LoginDeats +
                ", Fullname=" + FullNameDeats +
                ", Address=" + AddressDeats +
                ", ContactDetails=" + ContactDeats +
                ", BankDetails=" + BankDeats +
                ", Tickets=" + Tickets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer cust = (Customer) o;

        if (id != null ? !id.equals(cust.id) : cust.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
