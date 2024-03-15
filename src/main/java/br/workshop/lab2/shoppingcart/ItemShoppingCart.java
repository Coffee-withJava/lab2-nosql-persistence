package br.workshop.lab2.shoppingcart;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema
public record ItemShoppingCart(@Schema String productId,
                               @Schema String name,
                               @Schema BigDecimal price,
                               @Schema Integer quantity,
                               @Schema BigDecimal total) {

}
