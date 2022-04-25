package com.emtlab.demo.service.impl;

import com.emtlab.demo.model.Author;
import com.emtlab.demo.model.Book;
import com.emtlab.demo.model.dto.BookDTO;
import com.emtlab.demo.repository.AuthorRepository;
import com.emtlab.demo.repository.BookRepository;
import com.emtlab.demo.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository _bookRepo;
    private final AuthorRepository _authorRepo;

    public BookServiceImpl(BookRepository bookRepo, AuthorRepository authorRepo) {
        this._bookRepo = bookRepo;
        this._authorRepo = authorRepo;
    }

    @Override
    public List<Book> findAll() {
        return _bookRepo.findAll();
    }

    @Override
    public void saveBook(BookDTO bookDTO) throws Exception {
        Author author = _authorRepo.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new Exception("Invalid Author ID"));

        Book book = new Book();
        book.setAuthor(author);
        book.setCategory(bookDTO.getCategory());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        book.setName(bookDTO.getName());
        _bookRepo.save(book);
    }

    @Override
    public void editBook(Long id, BookDTO bookDTO) throws Exception{
        Book book = _bookRepo.findById(id)
                .orElseThrow(() -> new Exception("Invalid Book ID"));
        Author author = _authorRepo.findById(bookDTO.getAuthorId())
                .orElseThrow(() -> new Exception("Invalid Author ID"));

        book.setAuthor(author);
        book.setCategory(bookDTO.getCategory());
        book.setAvailableCopies(bookDTO.getAvailableCopies());
        book.setName(bookDTO.getName());

        _bookRepo.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        _bookRepo.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) throws Exception {
        Book book = _bookRepo.findById(id)
                .orElseThrow(() -> new Exception("Invalid Book ID"));

        if(book.getAvailableCopies() > 0){
            book.setAvailableCopies(book.getAvailableCopies() - 1);
        }

        _bookRepo.save(book);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return _bookRepo.findById(id);
    }
}
