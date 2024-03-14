package br.workshop.controller;

import br.workshop.entity.Event;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.Optional;
import java.util.stream.Stream;

@RequestScoped
public class EventService {

    @PersistenceContext(name = "jpa-unit")
    private EntityManager em;

    public Event add(Event event) {
        em.persist(event);
        return event;
    }

    public void delete(Event event) {
        em.remove(event);
    }

    public Optional<Event> findById(String id) {
        return Optional.ofNullable(em.find(Event.class, id));
    }

    public Stream<Event> listAll() {
        return em.createQuery("select e from Event e", Event.class).getResultStream();
    }
}
