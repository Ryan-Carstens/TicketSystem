package za.ac.rcarstens.assignment6_2.domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by student on 2015/08/05.
 */
@Embeddable
public class TicketDetails implements Serializable
{
    private double ticketPrice;
    private String date;
    private String ticketType;

    //Constructors
    private TicketDetails()
    {

    }

    public TicketDetails(Builder builder)
    {
        this.ticketPrice = builder.ticketPrice;
        this.date = builder.date;
        this.ticketType = builder.ticketType;
    }

    //Get Methods
    public Double getTicketPrice()
    {
        return ticketPrice;
    }

    public String getDate()
    {
        return date;
    }

    public String getTicketType()
    {
        return ticketType;
    }

    public static class Builder
    {
        private double ticketPrice;
        private String date;
        private String ticketType;

        public Builder(Double ticketPrice)
        {
            this.ticketPrice = ticketPrice;
        }

        public Builder date(String date)
        {
            this.date = date;
            return this;
        }

        public Builder ticketType(String ticketType)
        {
            this.ticketType = ticketType;
            return this;
        }

        public Builder copy(TicketDetails ticketDetails)
        {
            this.ticketPrice = ticketDetails.ticketPrice;
            this.date = ticketDetails.date;
            this.ticketType = ticketDetails.ticketType;
            return this;
        }

        public TicketDetails build()
        {
            return new TicketDetails(this);
        }
    }

}
