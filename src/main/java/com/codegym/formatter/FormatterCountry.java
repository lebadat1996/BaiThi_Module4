package com.codegym.formatter;

import com.codegym.model.Country;
import com.codegym.service.country.CountryService;
import com.codegym.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class FormatterCountry implements Formatter<Country> {
    @Autowired
    private ICountryService countryService;
    @Autowired
    public FormatterCountry (CountryService countryService){
        this.countryService= countryService;
    }
    @Override
    public Country parse(String text, Locale locale) throws ParseException {
        return countryService.getById(Long.parseLong(text)).get();
    }

    @Override
    public String print(Country object, Locale locale) {
        return null;
    }
}
