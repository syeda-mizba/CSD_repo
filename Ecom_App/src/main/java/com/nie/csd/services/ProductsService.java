package com.nie.csd.services;

import com.nie.csd.models.Products;
import com.nie.csd.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ProductsService {

    @Autowired
    ProductRepository repository;

    public List<Products> getAllProducts() {
        return repository.findAll();
    }

    public Products getByProductId(String id) {
        return repository.findById(id).get();
    }

    public Products addProduct(Products products) {
        return repository.save(products);
    }

    public Products updateProduct(String id, Products products) {
        Products existingproduct=repository.findById(id).get();
        if(existingproduct!=null){
          existingproduct.setName(products.getName());
          existingproduct.setDescription(products.getDescription());
          existingproduct.setCategory(products.getCategory());
          existingproduct.setTags(products.getTags());
          existingproduct.setPrice(products.getPrice());
          existingproduct.setStock(products.getStock());
          return repository.save(existingproduct);
        }
        return repository.save(products);
    }

    public void deleteProduct(String id) {
        Products existingproduct=repository.findById(id).get();
        if(existingproduct!=null){
            repository.delete(existingproduct);
            System.out.println("Product deleted successfully");
        }
        else{
            System.out.println("Product not found");
        }
    }
}
