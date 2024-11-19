package org.apache.servicecomb.fence.resource.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "event")
    private String event;

    @Column(name = "eventDate")
    private LocalDateTime eventTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}
