package br.workshop.controller;


import br.workshop.entity.Event;
import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Delete;
import jakarta.data.repository.Query;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

import java.util.Optional;
import java.util.stream.Stream;

@Repository
public interface Calendar {
    @Save
    Event save(Event event);

    @Delete
    void delete(Event event);

    Optional<Event> findById(String id);

    @Query("select e from Event e")
    Stream<Event> findAll();
}
