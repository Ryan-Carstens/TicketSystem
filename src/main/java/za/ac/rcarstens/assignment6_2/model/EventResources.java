package za.ac.rcarstens.assignment6_2.model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.rcarstens.assignment6_2.domain.EventDetails;

/**
 * Created by student on 2015/08/20.
 */
public class EventResources extends ResourceSupport {

    private Long resID;
    private String eventName;
    private EventDetails EventDetails;
    private Long totalTickets;

    //Constructors
    private EventResources() {
    }

    public EventResources(Builder builder){
        this.resID = builder.resID;
        this.eventName = builder.eventName;
        this.EventDetails=builder.EventDetails;
        this.totalTickets=builder.totalTickets;
    }


    //Get Methods
    public Long getID() {
        return resID;
    }

    public EventDetails getEventDetails() {
        return EventDetails;
    }

    public String getEventName()
    {
        return eventName;
    }

    public Long getTotalTickets() {
        return totalTickets;
    }


    //Builder Subclass
    public static class Builder{

        private Long resID;
        private String eventName;
        private EventDetails EventDetails;
        private Long totalTickets;

        public Builder(String eventName) { this.eventName = eventName;
        }

        public Builder resID(Long value){
            this.resID=value;
            return this;

        }

        public Builder eventDetails(EventDetails value) {
            this.EventDetails = value;
            return this;

        }

        public Builder totalTickets(Long value){
            this.totalTickets=value;
            return this;

        }

        public Builder copy(EventResources value){
            this.resID = value.resID;
            this.eventName = value.eventName;
            this.EventDetails=value.EventDetails;
            this.totalTickets=value.totalTickets;

            return this;
        }

        public EventResources build(){
            return new EventResources(this);
        }


    }

    @Override
    public String toString() {
        return "Event{" +
                "Event_id='" + resID + '\'' +
                ", EventDetails=" + EventDetails +
                ", totalTickets=" + totalTickets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EventResources eventR = (EventResources) o;

        if (resID != null ? !resID.equals(eventR.resID) : eventR.resID != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return resID != null ? resID.hashCode() : 0;
    }
}

