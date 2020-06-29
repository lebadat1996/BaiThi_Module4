package com.codegym.service.country;

import com.codegym.model.Country;
import com.codegym.repository.ICountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    ICountryRepository countryRepository;

    @Override
    public Iterable<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country model) {
        return countryRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
