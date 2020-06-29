package com.codegym.service.city;

import com.codegym.model.City;
import com.codegym.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService{
    @Autowired
    ICityRepository cityRepository;
    @Override
    public Iterable<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> getById(Long id) {
        return cityRepository.findById(id);
    }

    @Override
    public City save(City model) {
        return cityRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        cityRepository.deleteById(id);
    }

    @Override
    public Page<City> findAll(Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

    @Override
    public Page<City> findAllByCityNameContaining(String Name, Pageable pageable) {
        return cityRepository.findAllByNameContaining(Name,pageable);
    }
}
