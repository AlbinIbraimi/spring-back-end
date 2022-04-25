package com.emtlab.demo.model;

import com.emtlab.demo.model.enums.Category;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer availableCopies;
    @Enumerated(EnumType.STRING)
    private Category category;
    @ManyToOne
    private Author author;

    public Book() {

    }

    public Book(Long id, String name, Integer availableCopies, Category category, Author author) {
        this.id = id;
        this.name = name;
        this.availableCopies = availableCopies;
        this.category = category;
        this.author = author;
    }
}
