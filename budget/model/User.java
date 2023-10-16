package com.example.codeengine.budget.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private Long id;

    private String name;

    private String email;

    @OneToMany
    private Set<Category> category;
    // one user can have many categories here
}
