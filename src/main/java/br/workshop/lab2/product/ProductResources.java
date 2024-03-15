package br.workshop.lab2.product;

import jakarta.data.page.Page;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotSupportedException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.jnosql.mapping.core.NoSQLPage;

import java.util.List;

@Path("/products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ProductResources {

    @POST
    public ProductResponse add(ProductRequest request) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @PUT
    @Path("{id}")
    public ProductResponse update(@PathParam("id") String id, ProductRequest request) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        //TODO
        throw new NotSupportedException("Not implemented yet.");
    }

    @GET
    public List<ProductResponse> listAll(@QueryParam("name") String name,
                                         @QueryParam("page") @DefaultValue("1") Long page,
                                         @QueryParam("size") @DefaultValue("10") Long size) {
        // TODO
        throw new NotSupportedException("Not implemented yet.");
    }

}
