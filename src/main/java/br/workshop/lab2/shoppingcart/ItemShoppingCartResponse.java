package br.workshop.lab2.shoppingcart;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema
public record ItemShoppingCartResponse(@Schema String productId,
                                       @Schema String productName,
                                       @Schema BigDecimal productPrice,
                                       @Schema Integer quantity,
                                       @Schema BigDecimal total) {

    public static ItemShoppingCartResponse of(ItemShoppingCart itemShoppingCart) {
        return new ItemShoppingCartResponse(itemShoppingCart.productId(),
                itemShoppingCart.productName(),
                itemShoppingCart.productPrice(),
                itemShoppingCart.quantity(), itemShoppingCart.total());
    }
}
