package com.codegym.service.city;

import com.codegym.model.City;
import com.codegym.service.IGenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGenericService<City> {
    Page<City> findAll(Pageable pageable);
    Page<City> findAllByCityNameContaining(String Name,Pageable pageable);
}
