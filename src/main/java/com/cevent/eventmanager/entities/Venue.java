package com.cevent.eventmanager.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String venueName;
    private String location;
    private int capacity;

    @OneToOne(mappedBy ="venue")
    @JsonBackReference
    private Event event;

    public Venue(int venueId, String venueName, String location, int capacity, Event event) {
        this.id = venueId;
        this.venueName = venueName;
        this.location = location;
        this.capacity = capacity;
        this.event = event;
    }

    public Venue() {
        super();
    }

    public int getVenueId() {
        return id;
    }

    public void setVenueId(int venueId) {
        this.id = venueId;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueId=" + id +
                ", venueName='" + venueName + '\'' +
                ", location='" + location + '\'' +
                ", capacity=" + capacity +
                ", event=" + event +
                '}';
    }
}
