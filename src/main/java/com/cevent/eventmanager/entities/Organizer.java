package com.cevent.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "organizers")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizerId;
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Contact contactInfo;

    @OneToMany(mappedBy = "organizer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Event> events;

    public Organizer(int organizerId, String name, Contact contactInfo, List<Event> events) {
        this.organizerId = organizerId;
        this.name = name;
        this.contactInfo = contactInfo;
        this.events = events;
    }

    public Organizer() {
        super();
    }

    public int getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(int organizerId) {
        this.organizerId = organizerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Contact getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(Contact contactInfo) {
        this.contactInfo = contactInfo;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "Organizer{" +
                "organizerId=" + organizerId +
                ", name='" + name + '\'' +
                ", contactInfo=" + contactInfo +
                ", events=" + events +
                '}';
    }
}
