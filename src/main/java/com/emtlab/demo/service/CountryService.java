package com.emtlab.demo.service;

import com.emtlab.demo.model.Country;
import com.emtlab.demo.model.dto.CountryDTO;

import java.util.List;
import java.util.Optional;

public interface CountryService {
    List<Country> findAll();
    void save(CountryDTO countryDTO);
    void delete(Long id);
    Optional<Country> findCountryById(Long id);
}
