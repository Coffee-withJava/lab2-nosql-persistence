package br.workshop.lab2.shoppingcart;

import br.workshop.lab2.product.Catalog;
import jakarta.inject.Inject;
import jakarta.validation.constraints.Positive;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/shopping-carts")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ShoppingCartsResources {

    @Inject
    Catalog catalog;

    @Inject
    Store store;


    @GET
    @Path("{customerId}")
    public ShoppingCartResponse shoppingCart(@PathParam("customerId") @Positive Long customerId) {
        ShoppingCart shoppingCart = store.findByCustomerId(customerId)
                .orElseGet(() -> store.save(new ShoppingCart(customerId)));
        return ShoppingCartResponse.of(shoppingCart);
    }

    @DELETE
    @Path("{customerId}")
    public void deleteShoppingCart(@PathParam("customerId") Long customerId) {
        store.findByCustomerId(customerId).ifPresent(store::delete);
    }

    @POST
    @Path("{customerId}/items/")
    public ShoppingCartResponse setItem(@PathParam("customerId") @Positive Long customerId,
                                        ItemShoppingCartRequest request) {

        var product = catalog.findById(request.id()).orElseThrow(BadRequestException::new);

        var shoppingCart = store.findByCustomerId(customerId)
                .orElseGet(() -> store.save(new ShoppingCart(customerId)));

        shoppingCart = shoppingCart
                .setItem(ItemShoppingCart.of(product, request.quantity()));

        store.save(shoppingCart);

        return ShoppingCartResponse.of(shoppingCart);
    }

    @DELETE
    @Path("{customerId}/items/{productId}")
    public ShoppingCartResponse removeItem(@PathParam("customerId") @Positive Long customerId,
                                           @PathParam("productId") String productId) {
        var product = catalog.findById(productId).orElseThrow(BadRequestException::new);

        var shoppingCart = store.findByCustomerId(customerId)
                .orElseGet(() -> store.save(new ShoppingCart(customerId)));

        ItemShoppingCart item = ItemShoppingCart.of(product, 0);

        shoppingCart = shoppingCart.setItem(item);

        store.save(shoppingCart);

        return ShoppingCartResponse.of(shoppingCart);
    }

}
