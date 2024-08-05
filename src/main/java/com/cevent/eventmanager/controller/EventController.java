package com.cevent.eventmanager.controller;

import com.cevent.eventmanager.entities.Event;
import com.cevent.eventmanager.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/events")
    public ResponseEntity<Event> addEvent(@RequestBody Event event) {
        Event event1 = null;
        try {
            event1 = eventService.addEvent(event);
            return ResponseEntity.status(HttpStatus.CREATED).body(event1);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents() {
        List<Event> events = eventService.getAllEvents();
        if (events.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(events);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") int id) {
        Event event = eventService.getEventById(id);
        if (event == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(event));
    }

    @PutMapping("/events/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable("id") int id, @RequestBody Event updatedEvent) {
        try {
            eventService.updateEvent(id, updatedEvent);
            return ResponseEntity.ok().body(updatedEvent);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/events/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable("id") int id) {
        try {
            eventService.deleteEventById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/events/venue/{venueId}")
    public ResponseEntity<Event> getEventByVenue(@PathVariable("venueId") int id) {
        Event event = eventService.getEventByVenue(id);
        if (event == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(event));
    }

    @GetMapping("/events/organizer/{organizerId}")
    public ResponseEntity<List<Event>> getEventByOrganizer(@PathVariable("organizerId") int id) {
        List<Event> events = eventService.getEventsByOrganizer(id);
        if (events.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(events));
    }
}