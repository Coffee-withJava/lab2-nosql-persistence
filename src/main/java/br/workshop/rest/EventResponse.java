package br.workshop.rest;

import br.workshop.entity.Event;
import br.workshop.entity.EventType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema
public record EventResponse(@Schema String id,@Schema String title, @Schema EventType type) {

    public static EventResponse of(Event event){
        return new EventResponse(event.getId(), event.getTitle(), event.getType());
    }

}
