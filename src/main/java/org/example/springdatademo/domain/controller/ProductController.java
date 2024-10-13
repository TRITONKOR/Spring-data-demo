package org.example.springdatademo.domain.controller;

import java.util.List;
import org.example.springdatademo.domain.service.CategoryService;
import org.example.springdatademo.domain.service.ProductService;
import org.example.springdatademo.persistence.entity.Category;
import org.example.springdatademo.persistence.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "products";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/category/{id}")
    public String getProductsByCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        List<Product> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        return "products";
    }

    @GetMapping("/filter")
    public String filterProducts(@RequestParam Double minPrice, @RequestParam Double maxPrice, Model model) {
        List<Product> products = productService.getProductsByPriceRange(minPrice, maxPrice);

        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "products";
    }
}
