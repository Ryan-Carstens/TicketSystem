package za.ac.rcarstens.assignment6_2.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.rcarstens.assignment6_2.domain.TicketDetails;

/**
 * Created by student on 2015/08/20.
 */
public class TicketResources extends ResourceSupport
{
    private Long resID;
    private TicketDetails TicketDetails;

    //Constructors
    private TicketResources() {
    }

    public TicketResources(Builder builder){
        resID=builder.resID;
        TicketDetails=builder.TicketDetails;
    }


    //Get Methods
    public Long getTicketResID() {
        return resID;
    }

    public TicketDetails getTicketDetails() {
        return TicketDetails;
    }

    //Builder Subclass
    public static class Builder{

        private Long resID;
        private TicketDetails TicketDetails;


        public Builder() {
        }


        public Builder resID(Long value){
            this.resID=value;
            return this;

        }

        public Builder ticketDetails(TicketDetails value){
            this.TicketDetails=value;
            return this;

        }

        public Builder copy(TicketResources value){
            this.resID=value.resID;
            this.TicketDetails=value.TicketDetails;

            return this;
        }

        public TicketResources build(){
            return new TicketResources(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TicketResources)) return false;

        TicketResources ticketR = (TicketResources) o;

        if (resID != null ? !resID.equals(ticketR.resID) : ticketR.resID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resID != null ? resID.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "resID=" + resID +
                ", TicketDetails=" + TicketDetails +
                '}';
    }
}