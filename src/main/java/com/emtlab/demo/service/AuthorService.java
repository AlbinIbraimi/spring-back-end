package com.emtlab.demo.service;

import com.emtlab.demo.model.Author;
import com.emtlab.demo.model.dto.AuthorDTO;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    List<Author> findAll();
    void saveAuthor(AuthorDTO authorDTO) throws Exception;
    void editAuthor(Long id, AuthorDTO authorDTO) throws Exception;
    void deleteAuthor(Long id);
    Optional<Author> findAuthorById(Long id);
}
