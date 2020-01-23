package com.bank.repository;

import com.bank.repository.impl.Pageable;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {
    //creat
    void save(E entity);

    //read
    Optional<E> findById(Integer id);

    default List<E> findAll(){
        return Collections.emptyList();
    }

    //update

    void update(E entity);

    //
    void deleteById(Integer id);
}
