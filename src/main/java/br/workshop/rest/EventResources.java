package br.workshop.rest;

import br.workshop.controller.EventService;
import br.workshop.entity.Event;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.Optional;

@RequestScoped
@Path("/events")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class EventResources {

    @Inject EventService eventService;


    @POST
    @Transactional
    public EventResponse add(EventRequest request){
        Event newEvent = request.create();
        eventService.add(newEvent);
        return EventResponse.of(newEvent);
    }

    @PUT
    @Path("{id}")
    @Transactional
    public EventResponse update(@PathParam("id") String id, EventRequest request){

        Event event = eventService.findById(id)
                .orElseThrow(NotFoundException::new);
        Optional.ofNullable(request.title()).ifPresent(event::setTitle);
        Optional.ofNullable(request.type()).ifPresent(event::setType);

        return EventResponse.of(event);
    }

    @Path("{id}")
    @GET
    public EventResponse get(@PathParam("id") String id){
        return eventService.findById(id)
                .map(EventResponse::of)
                .orElseThrow(NotFoundException::new);
    }


    @GET
    public List<EventResponse> listAll(){
        return eventService.listAll().map(EventResponse::of).toList();
    }

    @Path("{id}")
    @DELETE
    @Transactional
    public void remove(@PathParam("id") String id){
        eventService.findById(id).ifPresent(eventService::delete);
    }

}
