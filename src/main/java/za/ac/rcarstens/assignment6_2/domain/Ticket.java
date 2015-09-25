package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by student on 2015/04/28.
 */
@Entity
public class Ticket implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private TicketDetails TicketDetails;

    //Constructors
    private Ticket() {
    }

    public Ticket(Builder builder){
        id=builder.id;
        TicketDetails=builder.TicketDetails;
    }


    //Get Methods
    public Long getTicketID() {
        return id;
    }

    public TicketDetails getTicketDetails() {
        return TicketDetails;
    }

    //Builder Subclass
    public static class Builder{

        private Long id;
        private TicketDetails TicketDetails;


        public Builder() {
        }


        public Builder id(Long value){
            this.id=value;
            return this;

        }

        public Builder ticketDetails(TicketDetails value){
            this.TicketDetails=value;
            return this;
        }

        public Builder copy(Ticket value){
            this.id=value.id;
            this.TicketDetails=value.TicketDetails;

            return this;
        }

        public Ticket build(){
            return new Ticket(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;

        Ticket ticket = (Ticket) o;

        if (id != null ? !id.equals(ticket.id) : ticket.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + id +
                ", TicketDetails=" + TicketDetails +
                '}';
    }
}
