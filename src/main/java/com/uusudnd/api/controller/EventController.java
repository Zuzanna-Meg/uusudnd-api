package com.uusudnd.api.controller;

import com.uusudnd.api.entity.Event;
import com.uusudnd.api.exception.EventNotFound;
import com.uusudnd.api.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    // get all
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = new ArrayList<>();
        eventRepository.findAll().forEach(events::add);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    // create
    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        Event newEvent = new Event(event.getTitle(), event.getDescription(), event.getStart(), event.getLocation(), event.getImageLink(), event.getTicketLink());
        eventRepository.save(newEvent);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }

    // get one
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {

        Optional<Event> eventData = eventRepository.findById(id);
        if (eventData.isPresent()) {
            return new ResponseEntity<>(eventData.get(), HttpStatus.OK);
        } else {
            throw new EventNotFound("Invalid Event Id");
        }
    }

    // delete one
    @DeleteMapping("/{id}")
    public ResponseEntity<Event> deleteEvent(@PathVariable("id") Long id) {

        Optional<Event> eventData = eventRepository.findById(id);
        if (eventData.isPresent()) {
            eventRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            throw new EventNotFound("Invalid Event Id");
        }
    }

    // amend one
    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") Long id, @RequestBody Event newevent) {
        Optional<Event> eventData = eventRepository.findById(id);
        if (eventData.isPresent()) {
            Event event = eventData.get();
            event.setTitle(newevent.getTitle());
            event.setDescription(newevent.getDescription());
            event.setStart(newevent.getStart());
            event.setLocation(newevent.getLocation());
            event.setImageLink(newevent.getImageLink());
            event.setTicketLink(newevent.getTicketLink());
            eventRepository.save(event);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            throw new EventNotFound("Invalid Event Id");
        }
    }
}