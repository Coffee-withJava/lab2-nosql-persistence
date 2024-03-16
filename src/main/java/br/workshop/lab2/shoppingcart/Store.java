package br.workshop.lab2.shoppingcart;

import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Delete;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

import java.util.Optional;

@Repository
public interface Store extends DataRepository<ShoppingCart, Long> {

    @Save
    ShoppingCart save(ShoppingCart shoppingCart);

    Optional<ShoppingCart> findByCustomerId(Long customerId);

    @Delete
    void delete(ShoppingCart shoppingCart);
}
