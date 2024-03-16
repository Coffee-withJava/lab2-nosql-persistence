package br.workshop.lab2.product;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema
public record ProductRequest(@Schema String name, @Schema(pattern = "url") String image, @Schema BigDecimal price) {
}
