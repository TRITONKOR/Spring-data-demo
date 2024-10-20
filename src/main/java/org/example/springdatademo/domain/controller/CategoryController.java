package org.example.springdatademo.domain.controller;

import java.util.List;
import org.example.springdatademo.domain.service.CategoryService;
import org.example.springdatademo.persistence.entity.Category;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getAllCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    @PostMapping("/add")
    public String addCategory(Category category) {
        categoryService.saveCategory(category);
        return "redirect:/categories";
    }
}
