package br.workshop.lab2.product;

import jakarta.annotation.PostConstruct;
import jakarta.data.page.PageRequest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
@Path("/products")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class ProductResources {

    @Inject
    Catalog catalog;

    @Inject
    @RestClient
    MakeupAPI makeupAPI;

    @PostConstruct
    public void postConstruct() {
        if (catalog.findAll(PageRequest.ofSize(1)).content().isEmpty()) {
            makeupAPI.get()
                    .forEach(product ->
                            catalog.save(Product.of(product.name(), product.image_link(), product.price())));
        }
    }

    @POST
    public ProductResponse add(ProductRequest request) {
        Product product = Product.of(request.name(), request.image(), request.price());
        return ProductResponse.of(catalog.save(product));
    }

    @PUT
    @Path("{id}")
    public ProductResponse update(@PathParam("id") String id, ProductRequest request) {

        Product product = catalog.findById(id)
                .orElseThrow(NotFoundException::new);

        product = Optional.ofNullable(request.name()).map(product::changeName).orElse(product);
        product = Optional.ofNullable(request.price()).map(product::changePrice).orElse(product);
        product = Optional.ofNullable(request.image()).map(product::changeImage).orElse(product);

        return ProductResponse.of(catalog.save(product));

    }

    @GET
    @Path("{id}")
    public ProductResponse get(@PathParam("id") String id) {
        return ProductResponse.of(
                catalog.findById(id).orElseThrow(NotFoundException::new)
        );
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id) {
        catalog.findById(id).ifPresentOrElse(
                catalog::delete,
                () -> {
                    throw new NotFoundException();
                }
        );
    }

    @GET
    public List<ProductResponse> listAll(@QueryParam("name") String name,
                                         @QueryParam("page") @DefaultValue("1") Integer page,
                                         @QueryParam("size") @DefaultValue("10") Integer size) {

        if (name != null) {
            return catalog.findByNameLike(name, PageRequest.ofSize(size).page(page)).stream().map(ProductResponse::of).toList();
        }
        return catalog.findAll(PageRequest.ofSize(size).page(page)).stream().map(ProductResponse::of).toList();
    }

}
