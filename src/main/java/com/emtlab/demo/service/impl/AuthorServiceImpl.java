package com.emtlab.demo.service.impl;

import com.emtlab.demo.model.Author;
import com.emtlab.demo.model.Country;
import com.emtlab.demo.model.dto.AuthorDTO;
import com.emtlab.demo.repository.AuthorRepository;
import com.emtlab.demo.repository.CountryRepository;
import com.emtlab.demo.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository _authorRepo;
    private final CountryRepository _countryRepo;

    public AuthorServiceImpl(AuthorRepository authorRepo, CountryRepository countryRepo) {
        this._authorRepo = authorRepo;
        this._countryRepo = countryRepo;
    }

    @Override
    public List<Author> findAll() { return _authorRepo.findAll();}

    @Override
    public void saveAuthor(AuthorDTO authorDTO) throws Exception {
        Country country = _countryRepo.findById(authorDTO.getCountryId())
                .orElseThrow(() -> new Exception("Invalid Country ID!"));
        Author author = new Author();
        author.setCountry(country);
        author.setName(authorDTO.getName());
        author.setSurname(authorDTO.getSurname());

        _authorRepo.save(author);
    }

    @Override
    public void editAuthor(Long id, AuthorDTO authorDTO) throws Exception{
        Author author = _authorRepo.findById(id)
                .orElseThrow(() -> new Exception("Invalid Author ID!"));
        Country country = _countryRepo.findById(authorDTO.getCountryId())
                .orElseThrow(() -> new Exception("Invalid Country ID!"));
        author.setSurname(authorDTO.getSurname());
        author.setCountry(country);
        author.setName(authorDTO.getName());

        _authorRepo.save(author);
    }

    @Override
    public void deleteAuthor(Long id) {
        _authorRepo.deleteById(id);
    }

    @Override
    public Optional<Author> findAuthorById(Long id) {
        return _authorRepo.findById(id);
    }


}
