package br.workshop.lab2.shoppingcart;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;
import java.util.List;

@Schema
public record ShoppingCartResponse(@Schema Long customerId,
                                   @Schema List<ItemShoppingCartResponse> items,
                                   @Schema BigDecimal total) {

}
