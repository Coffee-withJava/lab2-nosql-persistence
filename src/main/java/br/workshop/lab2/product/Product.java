package br.workshop.lab2.product;


import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Entity
public record Product(
        @Id String id,
        @Column String name,
        @Column String image,
        @Column BigDecimal price
) {

    public Product {
        price = Optional.ofNullable(price).orElse(BigDecimal.ZERO);
    }

    public static Product of(String name, String image, BigDecimal price) {
        return new Product(UUID.randomUUID().toString(), name, image, price);
    }

    public Product changeName(String name) {
        return new Product(id, name, image, price);
    }

    public Product changeImage(String image) {
        return new Product(id, name, image, price);
    }

    public Product changePrice(BigDecimal price) {
        return new Product(id, name, image, price);
    }
}
