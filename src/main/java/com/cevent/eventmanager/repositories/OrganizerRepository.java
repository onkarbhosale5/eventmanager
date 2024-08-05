package com.cevent.eventmanager.repositories;

import com.cevent.eventmanager.entities.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizerRepository extends JpaRepository<Organizer,Integer> {
}
