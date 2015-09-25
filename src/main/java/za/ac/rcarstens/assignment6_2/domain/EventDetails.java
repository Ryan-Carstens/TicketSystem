package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/05.
 */
@Embeddable
public class EventDetails implements Serializable
{

    private String eventAddress;
    private String eventType;
    private String eventDate;
    private String eventTime;

    //Constructors
    private EventDetails()
    {

    }

    public EventDetails(Builder builder)
    {
        this.eventAddress = builder.eventAddress;
        this.eventType = builder.eventType;
        this.eventDate = builder.eventDate;
        this.eventTime = builder.eventTime;
    }

    //Get Methods


    public String getEventAddress()
    {
        return eventAddress;
    }

    public String getEventType()
    {
        return eventType;
    }

    public String getEventDate()
    {
        return eventDate;
    }

    public String getEventTime()
    {
        return eventTime;
    }

    public static class Builder
    {

        private String eventAddress;
        private String eventType;
        private String eventDate;
        private String eventTime;

        public Builder(String eventAddress)
        {
            this.eventAddress = eventAddress;
        }

        public Builder eventType(String eventType)
        {
            this.eventType = eventType;
            return this;
        }

        public Builder eventDate(String eventDate)
        {
            this.eventDate = eventDate;
            return this;
        }

        public Builder eventTime(String eventTime)
        {
            this.eventTime = eventTime;
            return this;
        }

        public Builder copy(EventDetails eventDetails)
        {

            this.eventAddress = eventDetails.eventAddress;
            this.eventType = eventDetails.eventType;
            this.eventDate = eventDetails.eventDate;
            this.eventTime = eventDetails.eventTime;
            return this;
        }

        public EventDetails build()
        {
            return new EventDetails(this);
        }
    }

}
