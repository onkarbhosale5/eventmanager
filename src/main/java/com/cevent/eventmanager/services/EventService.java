package com.cevent.eventmanager.services;

import com.cevent.eventmanager.entities.Event;
import com.cevent.eventmanager.entities.Organizer;
import com.cevent.eventmanager.entities.Venue;
import com.cevent.eventmanager.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public Event addEvent(Event event) {
        return eventRepository.save(event);
    }

    public List<Event> getAllEvents() {
         return eventRepository.findAll();
    }

    public Event getEventById(int id) {
        Event event = null;
        try {
            event = eventRepository.findById(id).orElse(null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return event;
//        return eventRepository.findById(id).orElse(null);
    }

    public Event updateEvent(int id, Event event) {
        Event existingEvent = eventRepository.findById(id).orElse(null);
        if (existingEvent != null) {
            existingEvent.setEventName(event.getEventName());
            existingEvent.setOrganizer(event.getOrganizer());
            existingEvent.setVenue(event.getVenue());
            existingEvent.setEventDate(event.getEventDate());
            return eventRepository.save(existingEvent);
        }
        return null;
    }

    public void deleteEventById(int id) {
        eventRepository.deleteById(id);
    }

    public Event getEventByVenue(int venueId){
        return eventRepository.getEventByVenueId(venueId);
    }

    public List<Event> getEventsByOrganizer(int organizerId) {
        return eventRepository.findAllByOrganizer_OrganizerId(organizerId);
    }
}
