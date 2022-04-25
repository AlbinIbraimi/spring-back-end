package com.emtlab.demo.model.dto;

import lombok.Data;

@Data
public class AuthorDTO {
    private String name;
    private String surname;
    private Long countryId;
}
