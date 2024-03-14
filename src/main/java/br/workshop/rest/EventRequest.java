package br.workshop.rest;

import br.workshop.entity.Event;
import br.workshop.entity.EventType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "EventRequest")
public record EventRequest(@Schema String title, @Schema EventType type) {

    public Event create() {
        return Event.builder()
                .withTitle(title)
                .withType(type)
                .build();
    }
}
