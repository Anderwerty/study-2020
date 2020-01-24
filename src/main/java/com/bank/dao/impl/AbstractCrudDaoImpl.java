package com.bank.dao.impl;

import com.bank.dao.ConnectorDB;
import com.bank.dao.CrudDao;
import com.bank.dao.DataBaseSqlRuntimeException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public abstract class AbstractCrudDaoImpl<E> implements CrudDao<E> {
    protected final ConnectorDB connector;
    private final String findById;

    protected AbstractCrudDaoImpl(ConnectorDB connector, String findById) {
        this.connector = connector;
        this.findById = findById;
    }

    @Override
    public void save(E entity) {

    }

    @Override
    public Optional<E> findById(Integer id) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(findById)) {
            preparedStatement.setInt(1, id);

            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapResultSetToEntity(resultSet));
                }
            }

        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }

        return Optional.empty();
    }

    @Override
    public void update(E entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    protected abstract E mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}
