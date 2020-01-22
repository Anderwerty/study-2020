package com.bank.repository;

import com.bank.repository.impl.Pageable;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<E> {
    //creat
    void save(E entity);

    //read
    Optional<E> findById(Integer id);

    List<E> findAll(int page, int itemsPerPage);

    default Pageable<E> findAll(Page page){
        return null;
    }

    long count();

    //update

    void update(E entity);

    //
    void deleteById(Integer id);
}
