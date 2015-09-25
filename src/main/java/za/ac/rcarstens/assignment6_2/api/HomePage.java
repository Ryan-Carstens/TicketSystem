package za.ac.rcarstens.assignment6_2.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.services.EventServices;

import java.util.List;

/**
 * Created by hashcode on 2015/04/07.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {
    @Autowired
    private EventServices service;
    @RequestMapping(value = "home",method = RequestMethod.GET)
    public String Index(){
        return "This is a Home Page";
    }

//    @RequestMapping(value = "/event",method = RequestMethod.GET)
//    public Event getEvent(){
//        List<Ticket> Tickets = new ArrayList<Ticket>();
//        EventDetails EventDeatsCopy = EventDetailsFactory.createEventDetails("17 my road", "Dinner", "20 March", "1700");
//        Event myEvent = new Event.Builder("AGM").eventDetails(EventDeatsCopy).Tickets(Tickets).build();
//
//        return myEvent;
//    }

    @RequestMapping(value = "viewEvents", method = RequestMethod.GET)
    public List<Event> getEvents(){
        return service.getAllEvents();
    }

}
