package com.example.codeengine.budget.model;

import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "expense")
@Data
public class Expense {
    @Id
    private Long id;

    private Instant expenseDate;

    private String description;

    @ManyToOne
    private User user;
    // many expenses can be connected with one user

    @ManyToOne
    private Category category;
    // many expenses can be connected with one category

}
