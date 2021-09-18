package com.formacionbdi.microservicios.app.usuarios.services;

import java.util.Optional;

public interface BaseService<T> {

    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T alumno);

    void deleteById(Long id);
}
