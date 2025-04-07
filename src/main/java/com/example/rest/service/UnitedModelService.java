package com.example.rest.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UnitedModelService<E, ID> {

    Page<E> findAll(Pageable pageable);

    E findById(ID id);

    E save(E entity);

    E update(ID id, E entity);

    void deleteById(ID id);

}
