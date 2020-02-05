package com.bank.mapper;

public interface Mapper<E, D> {
    E mapDomainToEntity(D item);

    D mapEntityToDomain(E enity);
}
