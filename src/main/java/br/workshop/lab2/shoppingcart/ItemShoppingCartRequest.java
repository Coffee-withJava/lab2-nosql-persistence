package br.workshop.lab2.shoppingcart;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema
public record ItemShoppingCartRequest(@Schema String id, @Schema Integer quantity) {
}
