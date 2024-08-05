package com.cevent.eventmanager.services;

import com.cevent.eventmanager.entities.Venue;
import com.cevent.eventmanager.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VenueService {

    @Autowired
    private VenueRepository venueRepository;

    public Venue addVenue(Venue venue) {
        return venueRepository.save(venue);
    }

    public Venue getVenueById(int id) {
        return venueRepository.findById(id).orElse(null);
    }

    public Venue updateVenue(int id,Venue venue) {
        Venue existingVenue = venueRepository.findById(id).orElse(null);
        if (existingVenue != null) {
            existingVenue.setVenueName(venue.getVenueName());
            existingVenue.setCapacity(venue.getCapacity());
            existingVenue.setLocation(venue.getLocation());
            return venueRepository.save(existingVenue);
        }
        return null;
    }

    public void deleteVenue(int id) {
        venueRepository.deleteById(id);
    }


}
