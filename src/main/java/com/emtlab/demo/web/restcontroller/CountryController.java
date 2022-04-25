package com.emtlab.demo.web.restcontroller;

import com.emtlab.demo.model.Country;
import com.emtlab.demo.model.dto.CountryDTO;
import com.emtlab.demo.service.CountryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
@CrossOrigin(origins = "http://localhost:3000")
public class CountryController {
    private final CountryService _countryService;

    public CountryController(CountryService countryService) {
        this._countryService = countryService;
    }

    @GetMapping
    public List<Country> getCountries(){
        return this._countryService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> findCountry(@PathVariable Long id)
    {
        try{
            this._countryService.findCountryById(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteCountry(@PathVariable Long id)
    {
        try {
            this._countryService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("");
        }
        catch (Exception ex){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Country> addNewCountry(@RequestBody CountryDTO countryDTO)
    {
        try {
            this._countryService.save(countryDTO);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            return ResponseEntity.badRequest().build();
        }
    }
}
