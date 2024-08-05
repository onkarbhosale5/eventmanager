package com.cevent.eventmanager.controller;

import com.cevent.eventmanager.entities.Organizer;
import com.cevent.eventmanager.services.OrganizerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrganizerController {

    @Autowired
    private OrganizerService organizationService;

    @PostMapping("/organizers")
    public ResponseEntity<Organizer> addOrganizer(@RequestBody Organizer organizer) {
        Organizer organizer1 = null;
        try {
            organizer1 = organizationService.addOrganizer(organizer);
            return ResponseEntity.status(HttpStatus.CREATED).body(organizer1);
        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/organizers/{id}")
    public ResponseEntity<Organizer> getOrganizerById(@PathVariable("id") int id) {
        Organizer organizer = organizationService.getOrganizerById(id);
        if(organizer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(organizer));
    }

    @PutMapping("/organizers/{id}")
    public ResponseEntity<Organizer> updateOrganizer(@PathVariable("id") int id, @RequestBody Organizer organizer) {
        try {
            organizationService.updateOrganizer(organizer, id);
            return ResponseEntity.ok().body(organizer);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/organizers/{id}")
    public ResponseEntity<Void> deleteOrganizer(@PathVariable("id") int id) {
        try {
            organizationService.deleteOrganizer(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
