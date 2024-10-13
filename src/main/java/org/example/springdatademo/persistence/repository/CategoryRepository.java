package org.example.springdatademo.persistence.repository;

import org.example.springdatademo.persistence.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
