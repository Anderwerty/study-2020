package com.bank.dao;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public interface CrudDao<E> {
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
