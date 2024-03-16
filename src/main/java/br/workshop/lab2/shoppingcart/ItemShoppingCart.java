package br.workshop.lab2.shoppingcart;

import br.workshop.lab2.product.Product;
import jakarta.nosql.Column;
import jakarta.nosql.Entity;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public record ItemShoppingCart(
        @Column String productId,
        @Column String productName,
        @Column BigDecimal productPrice,
        @Column Integer quantity,
        @Column BigDecimal total
) {

    public static ItemShoppingCart of(Product product) {
        return of(product, 1);
    }

    public static ItemShoppingCart of(Product product, Integer quantity) {
        return of(product.id(), product.name(), product.price(), quantity);
    }

    public static ItemShoppingCart of(String productId, String productName, BigDecimal productPrice, Integer quantity) {
        return new ItemShoppingCart(productId, productName, productPrice, quantity, productPrice.multiply(BigDecimal.valueOf(quantity)));
    }

    public ItemShoppingCart withQuantity(Integer quantity) {
        return of(productId(), productName(), productPrice(), quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemShoppingCart that = (ItemShoppingCart) o;
        return Objects.equals(productId, that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }
}
