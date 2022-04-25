package com.emtlab.demo.web.restcontroller;

import com.emtlab.demo.model.Book;
import com.emtlab.demo.model.dto.BookDTO;
import com.emtlab.demo.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {

    private final BookService _bookService;

    public BookController(BookService bookService) {
        this._bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks()
    {
        return this._bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findBook(@PathVariable Long id)
    {
        try
        {
            this._bookService.findBookById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id)
    {
        try
        {
            this._bookService.deleteBook(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        catch (Exception ex)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @GetMapping("/taken/{id}")
    public ResponseEntity<Book> markAsTaken(@PathVariable Long id)
    {
        try
        {
            this._bookService.markAsTaken(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Book> addNewBook(@RequestBody BookDTO bookDTO)
    {
        try
        {
            this._bookService.saveBook(bookDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody BookDTO bookDTO)
    {
        try
        {
            this._bookService.editBook(id,bookDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }
}
