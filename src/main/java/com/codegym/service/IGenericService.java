package com.codegym.service;

import java.util.Optional;

public interface IGenericService<T> {
    Iterable<T> findAll();

    Optional<T> getById(Long id);

    T save(T model);

    void remove(Long id);
}
