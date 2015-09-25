package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Embedded
    private EventDetails EventDetails;
    private String eventName;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="Event_id")
    private List<Ticket> Tickets;

    //Constructors
    private Event() {
    }

    public Event(Builder builder){
        this.id = builder.id;
        this.eventName = builder.eventName;
        this.EventDetails=builder.EventDetails;
        this.Tickets=builder.Tickets;
    }


    //Get Methods
    public Long getID() {
        return id;
    }

    public EventDetails getEventDetails() {
        return EventDetails;
    }

    public String getEventName()
    {
        return eventName;
    }

    public List<Ticket> getTickets() {
        return Tickets;
    }


    //Builder Subclass
    public static class Builder{

        private Long id;
        private String eventName;
        private EventDetails EventDetails;
        private List<Ticket> Tickets;

        public Builder(String eventName) { this.eventName = eventName;
        }

        public Builder id(Long value){
            this.id=value;
            return this;

        }

        public Builder eventDetails(EventDetails value) {
            this.EventDetails = value;
            return this;

        }

        public Builder Tickets(List<Ticket> value){
            this.Tickets=value;
            return this;
        }

        public Builder copy(Event value){
            this.id = value.id;
            this.eventName = value.eventName;
            this.EventDetails=value.EventDetails;
            this.Tickets=value.Tickets;

            return this;
        }

        public Event build(){
            return new Event(this);
        }


    }

    @Override
    public String toString() {
        return "Event{" +
                "Event_id='" + id + '\'' +
                ", EventDetails=" + EventDetails +
                ", Tickets=" + Tickets +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (id != null ? !id.equals(event.id) : event.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
