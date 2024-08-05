package com.cevent.eventmanager.services;

import com.cevent.eventmanager.entities.Organizer;
import com.cevent.eventmanager.repositories.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizationRepository;

    public Organizer addOrganizer(Organizer organizer){
        return organizationRepository.save(organizer);
    }

    public Organizer getOrganizerById(int id){
        return organizationRepository.findById(id).orElse(null);
    }

    public Organizer updateOrganizer(Organizer organizer, int id){
        Organizer existingOrganizer = organizationRepository.findById(id).orElse(null);
        if(existingOrganizer != null){
            existingOrganizer.setName(organizer.getName());
            existingOrganizer.setContactInfo(organizer.getContactInfo());
            return organizationRepository.save(existingOrganizer);
        }
        return null;
    }

    public void deleteOrganizer(int id){
        organizationRepository.deleteById(id);
    }

}
