package com.emtlab.demo.model.dto;

import com.emtlab.demo.model.enums.Category;
import lombok.Data;

@Data
public class BookDTO {
    private String name;
    private Category category;
    private Long authorId;
    private Integer availableCopies;

    public BookDTO(String name, Category category, Long authorId, Integer availableCopies){
        this.name = name;
        this.category = category;
        this.authorId = authorId;
        this.availableCopies = availableCopies;
    }
}