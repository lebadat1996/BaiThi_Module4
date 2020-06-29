package com.codegym.repository;

import com.codegym.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepository extends CrudRepository<Country,Long> {
}
