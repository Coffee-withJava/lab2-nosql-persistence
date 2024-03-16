package br.workshop.lab2.shoppingcart;

import jakarta.nosql.Column;
import jakarta.nosql.Entity;
import jakarta.nosql.Id;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Entity
public class ShoppingCart {

    @Id
    private Long customerId;

    @Column
    private List<ItemShoppingCart> items = new LinkedList<>();

    @Column
    private BigDecimal total = BigDecimal.ZERO;

    public ShoppingCart() {
    }

    public ShoppingCart(Long customerId) {
        this.customerId = customerId;
    }

    public Long customerId() {
        return customerId;
    }

    public ShoppingCart setItem(ItemShoppingCart item) {
        if (item == null) {
            return this;
        }
        var itemsPerId = itemsById(this.items);
        itemsPerId.merge(item.productId(), item, (oldItem, newItem) -> oldItem.withQuantity(newItem.quantity()));
        this.items = itemsPerId.values().stream().filter(itemShoppingCart -> itemShoppingCart.quantity() > 0).toList();
        calculateTotal();
        return this;
    }

    private void calculateTotal() {
        this.total = this.items.stream().map(ItemShoppingCart::total).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Map<String, ItemShoppingCart> itemsById(List<ItemShoppingCart> items) {
        Map<String, ItemShoppingCart> itemsPerId = new LinkedHashMap<>();
        items.forEach(itemShoppingCart -> itemsPerId.put(itemShoppingCart.productId(), itemShoppingCart));
        return itemsPerId;
    }

    public List<ItemShoppingCart> items() {
        return items;
    }

    public BigDecimal total() {
        return total;
    }
}
