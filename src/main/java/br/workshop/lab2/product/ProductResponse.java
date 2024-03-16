package br.workshop.lab2.product;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.math.BigDecimal;

@Schema
public record ProductResponse(@Schema String id,
                              @Schema String name,
                              @Schema(pattern = "url") String image,
                              @Schema BigDecimal price) {
    public static ProductResponse of(Product product) {
        return new ProductResponse(product.id(), product.name(), product.image(), product.price());
    }
}
