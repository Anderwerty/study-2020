package com.bank.repository;

import com.bank.repository.impl.Pageable;

import java.util.List;

public interface CrudPageableRepository<E> extends CrudRepository<E> {

    List<E> findAll(int page, int itemsPerPage);

    default Pageable<E> findAll(Page page){
        return null;
    }

    long count();
}
