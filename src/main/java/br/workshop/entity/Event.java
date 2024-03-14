package br.workshop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Event {

    public static EventBuilder builder() {
        return new EventBuilder();
    }

    public static class EventBuilder {

        private String title;
        private EventType type;

        public EventBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public EventBuilder withType(EventType type) {
            this.type = type;
            return this;
        }

        public Event build() {
            Event event = new Event();
            event.id = UUID.randomUUID().toString();
            event.setTitle(title);
            event.setType(type);
            return event;
        }
    }

    @Id
    private String id;

    @Column
    private String title;

    @Column
    @Enumerated(EnumType.STRING)
    private EventType type;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(id, event.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
