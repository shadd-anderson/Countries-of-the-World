package com.countries.countrylist.controller;

import com.countries.countrylist.data.CountryRepository;
import com.countries.countrylist.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CountryController {
    @Autowired
    private CountryRepository repository;

    @RequestMapping("/")
    public String index(ModelMap model) {
        List<Country> allCountries = repository.getAllCountries();
        model.put("countries", allCountries);
        return "index";
    }

    @RequestMapping("/{slug}")
    public String country(@PathVariable String slug, ModelMap model) {
        Country country = repository.findBySlug(slug);
        model.put("country", country);
        return "country";
    }

    @RequestMapping("/by-population")
    public String byPopulation(ModelMap model) {
        List<Country> countries = repository.countriesByPopulation();
        model.put("countries", countries);
        return "index";
    }

    @RequestMapping("/by-name")
    public String byName(ModelMap model) {
        List<Country> countries = repository.countriesByName();
        model.put("countries", countries);
        return "index";
    }
}
