package za.ac.rcarstens.assignment6_2.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.rcarstens.assignment6_2.domain.Event;
import za.ac.rcarstens.assignment6_2.services.EventServices;

import java.util.List;

/**
 * Created by student on 2015/09/25.
 */
@RestController
@RequestMapping("/api/**")
public class EventPage {
    @Autowired
    private EventServices service;

    //-------------------Retrieve All Events--------------------------------------------------------

    @RequestMapping(value = "/events/", method = RequestMethod.GET)
    public ResponseEntity<List<Event>> listAllEvents() {
        List<Event> Events = service.getAllEvents();
        if(Events.isEmpty()){
            return new ResponseEntity<List<Event>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Event>>(Events, HttpStatus.OK);
    }


    //-------------------Retrieve Single Event--------------------------------------------------------

    @RequestMapping(value = "/event/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Event> getEvent(@PathVariable("id") long id) {
        System.out.println("Fetching Event with id " + id);
        Event Event = service.findById(id);
        if (Event == null) {
            System.out.println("Event with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Event>(Event, HttpStatus.OK);
    }



    //-------------------Create a Event--------------------------------------------------------

    @RequestMapping(value = "/event/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEvent(@RequestBody Event event,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Event " + event.getEventName());

//     USE THIS IF YOU WANT TO CHECK UNIQUE OBJECT
//      if (SubjectService.isSubjectExist(Subject)) {
//            System.out.println("A Subject with name " + Subject.getName() + " already exist");
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        service.save(event);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/subject/{id}").buildAndExpand(event.getID()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Event --------------------------------------------------------

    @RequestMapping(value = "/event/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Event> updateEvent(@PathVariable("id") long id, @RequestBody Event Event) {
        System.out.println("Updating Event " + id);

        Event currentEvent = service.findById(id);

        if (currentEvent==null) {
            System.out.println("Event with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }

        Event updatedEvent = new Event
                .Builder(currentEvent.getEventName())
                .copy(currentEvent)
                .build();
        service.update(updatedEvent);
        return new ResponseEntity<Event>(updatedEvent, HttpStatus.OK);
    }

    //------------------- Delete a Event --------------------------------------------------------

    @RequestMapping(value = "/event/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Event> deleteEvent(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Event with id " + id);

        Event event = service.findById(id);
        if (event == null) {
            System.out.println("Unable to delete. Subject with id " + id + " not found");
            return new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
        }

        service.delete(event);
        return new ResponseEntity<Event>(HttpStatus.NO_CONTENT);
    }
}
