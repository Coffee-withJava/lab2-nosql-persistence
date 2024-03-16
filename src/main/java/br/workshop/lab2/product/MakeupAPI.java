package br.workshop.lab2.product;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import java.math.BigDecimal;
import java.util.List;

@RegisterRestClient
@Path("/api/v1")
@Consumes({MediaType.APPLICATION_JSON})
public interface MakeupAPI {

    @Path("/products.json")
    @GET
    public List<MakeupProduct> get();

    public static record MakeupProduct(String name, String image_link, BigDecimal price) {
    }
}