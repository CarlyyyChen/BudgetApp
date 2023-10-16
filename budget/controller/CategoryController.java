package com.example.codeengine.budget.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.codeengine.budget.model.Category;
import com.example.codeengine.budget.repository.CategoryRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryController categoryController) {
        super();
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories")
    Collection<Category> categories() {
        return categoryRepository.findAll();
        // select * from category
    }

    @GetMapping("/category/{id}")
    ResponseEntity<?> getCategory(@PathVariable Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/category")
    ResponseEntity<Category> createCategory(@Validated @RequestBody Category category) throws URISyntaxException {
        Category result = categoryRepository.save(category);
        // above is equivalent to insert into table....
        // because of JPA we don't have to use sql here
        return ResponseEntity.created(new URI("/api/category" + result.getId())).body(result);
    }

    @PutMapping("/category/{id}")
    ResponseEntity<Category> updateCategory(@RequestBody Category category) {
        Category result = categoryRepository.save(category);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/category/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        categoryRepository.deleteById(id);
        return ResponseEntity.ok().build();
        // don't send anything embodied, just build a response body of ok
    }

}
