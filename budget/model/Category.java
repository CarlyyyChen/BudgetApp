package com.example.codeengine.budget.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    private Long id;

    @NonNull
    // Travel, Grocery, ...
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

}
