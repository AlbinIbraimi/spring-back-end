package com.emtlab.demo.service;

import com.emtlab.demo.model.Book;
import com.emtlab.demo.model.dto.BookDTO;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();
    void saveBook(BookDTO bookDTO) throws Exception;
    void editBook(Long id, BookDTO bookDTO) throws Exception;
    void deleteBook(Long id);
    void markAsTaken(Long id) throws Exception;
    Optional<Book> findBookById(Long id);
}
