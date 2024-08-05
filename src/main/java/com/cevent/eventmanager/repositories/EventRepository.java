package com.cevent.eventmanager.repositories;

import com.cevent.eventmanager.entities.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event,Integer> {

    public Event getEventByVenueId(int venueId);
    public List<Event> findAllByOrganizer_OrganizerId(int organizerId);
}
