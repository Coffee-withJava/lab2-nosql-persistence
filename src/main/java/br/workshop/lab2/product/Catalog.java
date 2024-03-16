package br.workshop.lab2.product;

import jakarta.data.page.Page;
import jakarta.data.page.PageRequest;
import jakarta.data.repository.DataRepository;
import jakarta.data.repository.Delete;
import jakarta.data.repository.Repository;
import jakarta.data.repository.Save;

import java.util.Optional;

@Repository
public interface Catalog extends DataRepository<Product,String> {

    @Save
    Product save(Product product);

    @Delete
    void delete(Product product);

    Optional<Product> findById(String id);

    Page<Product> findAll(PageRequest pageable);

    Page<Product> findByNameLike(String name, PageRequest pageable);

}
