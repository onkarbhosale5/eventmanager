package com.cevent.eventmanager.controller;

import com.cevent.eventmanager.entities.Venue;
import com.cevent.eventmanager.services.VenueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class VenueController {

    @Autowired
    private VenueService venueService;

    @PostMapping("/venues")
    public ResponseEntity<Venue> addVenue(@RequestBody Venue venue) {
        Venue venue1 = null;
        try {
            venue1 = venueService.addVenue(venue);
            return ResponseEntity.status(HttpStatus.CREATED).body(venue1);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/venues/{id}")
    public ResponseEntity<Venue> getVenueById(@PathVariable int id) {
        Venue venue = venueService.getVenueById(id);
        if (venue == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(venue));
    }

    @PutMapping("/venues/{id}")
    public ResponseEntity<Venue> updateVenue(@PathVariable("id") int id, @RequestBody Venue updatedVenue) {
        try {
            venueService.updateVenue(id, updatedVenue);
            return ResponseEntity.ok().body(updatedVenue);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/venues/{id}")
    public ResponseEntity<Void> deleteVenue(@PathVariable("id") int id) {
        try {
            venueService.deleteVenue(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
