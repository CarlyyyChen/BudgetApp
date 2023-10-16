package com.example.codeengine.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codeengine.budget.model.Category;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    // findBy + field name with first letter capitalized
    Optional<Category> findById(Long id);
}
