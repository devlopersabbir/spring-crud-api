package com.devlopersabbir.crud.controller;
import com.devlopersabbir.crud.entity.Product;
import com.devlopersabbir.crud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService service;

    // create single product
    @PostMapping("/product-create")
    public Product storeProduct(@RequestBody Product product) {
        return service.storeProduct(product);
    }

    // create multiple product
    @PostMapping("/products-multi")
    public List<Product> createMultiProduct(@RequestBody List<Product> products){
        return service.saveProducts(products);
    }

    // get all product
    @GetMapping("/get-products")
    public List<Product> getAllProduct(){
        return service.getAllProducts();
    }

    // get single product by id
    @GetMapping("/get-product")
    public Product getSingleProductById(@RequestParam int id){
        return service.getSingleProduct(id);
    }

    // delete product by id
    @DeleteMapping("/delete-product")
    public String deleteProductById(@RequestParam int id) {
        return service.deleteProduct(id);
    }

    // update product by id
    @PutMapping("/update-product")
    public String updateProductById(@RequestBody Product product) {
        return service.updateProduct(product);
    }
}
