package com.devlopersabbir.crud.service;
import com.devlopersabbir.crud.entity.Product;
import com.devlopersabbir.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // Save single product
    public Product storeProduct(Product product) {
        return repository.save(product);
    }

    // save list of products
    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    // get all product
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // get single product by id
    public Product getSingleProduct(int id) {
        return repository.findById(id).orElse(null);
    }

    // get product by name
    public Product getSingleProductByName(String name) {
        return repository.findByName(name);
    }

    // get single product and delete
    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "Product Deleted Successfully!";
    }

    // get single product and update
    public String updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);

        if(existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());

            repository.save(existingProduct);
            return "Product is updated!";
        }else {
            return "Product not found!";
        }
    }
}