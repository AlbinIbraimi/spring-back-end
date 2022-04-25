package com.emtlab.demo.service.impl;

import com.emtlab.demo.model.Country;
import com.emtlab.demo.model.dto.CountryDTO;
import com.emtlab.demo.repository.CountryRepository;
import com.emtlab.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository _countryRepo;

    public CountryServiceImpl(CountryRepository countryRepo) {
        this._countryRepo = countryRepo;
    }

    @Override
    public List<Country> findAll() {
        return _countryRepo.findAll();
    }

    @Override
    public void save(CountryDTO countryDTO) {
        Country country = new Country();
        country.setName(countryDTO.getName());
        country.setContinent(countryDTO.getContinent());

        _countryRepo.save(country);
    }

    @Override
    public void delete(Long id) {
        _countryRepo.deleteById(id);
    }

    @Override
    public Optional<Country> findCountryById(Long id) {
        return _countryRepo.findById(id);
    }
}
