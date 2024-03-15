package br.workshop.lab2.shoppingcart;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotSupportedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/shopping-carts")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ShoppingCartsResources {

    @GET
    @Path("{customerId}")
    public ShoppingCartResponse shoppingCart(@PathParam("customerId") String customerId) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @DELETE
    @Path("{customerId}")
    public void deleteShoppingCart(@PathParam("customerId") String customerId) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @POST
    @Path("{customerId}/items/")
    public ShoppingCartResponse setItem(@PathParam("customerId") String customerId,
                                             ItemShoppingCartRequest request) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @DELETE
    @Path("{customerId}/items/{productId}")
    public ShoppingCartResponse removeItem(@PathParam("customerId") String customerId,
                                             @PathParam("productId") String productId) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

}
