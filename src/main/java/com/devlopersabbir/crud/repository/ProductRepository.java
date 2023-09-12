package com.devlopersabbir.crud.repository;
import com.devlopersabbir.crud.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
Product findByName(String name);
}
