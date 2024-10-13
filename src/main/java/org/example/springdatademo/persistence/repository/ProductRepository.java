package org.example.springdatademo.persistence.repository;

import java.util.List;
import org.example.springdatademo.persistence.entity.Category;
import org.example.springdatademo.persistence.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    Page<Product> findAll(Pageable pageable);

    List<Product> findByPriceBetween(Double minPrice, Double maxPrice);
}
