package com.emtlab.demo.web.restcontroller;

import com.emtlab.demo.model.Author;
import com.emtlab.demo.model.dto.AuthorDTO;
import com.emtlab.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthorController {

    private final AuthorService _authorService;

    public AuthorController(AuthorService authorService) {
        this._authorService = authorService;
    }

    @GetMapping
    public List<Author> getAuthors(){ return _authorService.findAll(); }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable Long id)
    {
        try{
            _authorService.deleteAuthor(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> findAuthor(@PathVariable Long id)
    {
        try {
            _authorService.findAuthorById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex)
        {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Author> addNewAuthor(@RequestBody AuthorDTO authorDTO)
    {
        try{
            _authorService.saveAuthor(authorDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Author> editAuthor(@PathVariable Long id ,@RequestBody AuthorDTO authorDTO)
    {
        try{
            _authorService.editAuthor(id, authorDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
