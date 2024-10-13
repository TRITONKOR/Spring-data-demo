package org.example.springdatademo.persistence;

import org.example.springdatademo.persistence.entity.Category;
import org.example.springdatademo.persistence.entity.Product;
import org.example.springdatademo.persistence.repository.CategoryRepository;
import org.example.springdatademo.persistence.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        for (int i = 1; i <= 5; i++) {
            Category category = new Category();
            category.setName("Category " + i);
            categoryRepository.save(category);

            for (int j = 1; j <= 3; j++) {
                Product product = new Product();
                product.setName("Product " + j + " of Category " + i);
                product.setPhoto("http://example.com/photo" + j + ".jpg");
                product.setPrice(10.0 * j);
                product.setCategory(category);
                productRepository.save(product);
            }
        }
    }
}
