package com.cognizant.orm_learn.controller;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/")
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }


    @GetMapping("/country/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        return countryService.findCountryByCode(code);
    }
}
