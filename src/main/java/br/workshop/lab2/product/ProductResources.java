package br.workshop.lab2.product;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Path("/products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ProductResources {

    @POST
    public ProductResponse add(ProductRequest request) {
        // TODO: implement me!
        return null;
    }

    @PUT
    @Path("{id}")
    public ProductResponse update(@PathParam("id") String id, ProductRequest request) {
        // TODO: implement me!
        return null;
    }

    @GET
    @Path("{id}")
    public ProductResponse get(@PathParam("id") String id) {
        // TODO: implement me!
        return null;
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        // TODO: implement me!
    }

    @GET
    public List<ProductResponse> listAll(@QueryParam("name") String name,
                                         @QueryParam("page") @DefaultValue("1") Integer page,
                                         @QueryParam("size") @DefaultValue("10") Integer size) {

        // TODO: implement me!
        return null;
    }

}
