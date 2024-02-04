package com.uusudnd.api.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "start")
    private LocalDateTime start;

    @Column(name = "location")
    private String location;

    @Column(name = "imageLink")
    private String imageLink;

    @Column(name = "ticketLink")
    private String ticketLink;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }

    public String getTicketLink() {
        return ticketLink;
    }

    public void setTicketLink(String ticketLink) {
        this.ticketLink = ticketLink;
    }

    public Event(){
        super();
    }

    public Event(Long id, String title, String description, LocalDateTime start, String location, String imageLink, String ticketLink) {
        super();
        this.id = id;
        this.title = title;
        this.description = description;
        this.start = start;
        this.location = location;
        this.imageLink = imageLink;
        this.ticketLink = ticketLink;
    }

    public Event(String title, String description, LocalDateTime start, String location, String imageLink, String ticketLink) {
        super();
        this.title = title;
        this.description = description;
        this.start = start;
        this.location = location;
        this.imageLink = imageLink;
        this.ticketLink = ticketLink;
    }
}
