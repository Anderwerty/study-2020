package com.bank.dao.impl;

import com.bank.dao.ConnectorDB;
import com.bank.dao.UserDao;
import com.bank.dao.exception.DataBaseSqlRuntimeException;
import com.bank.entity.UserEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserCrudDaoImpl extends AbstractCrudDaoImpl<UserEntity> implements UserDao {

    private static final String FIND_BY_EMAIL_QUERY = "SELECT * FROM users WHERE email=?";
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM users WHERE id=?";
    private static final String FIND_ALL_QUERY = "SELECT * FROM users";

    public UserCrudDaoImpl(ConnectorDB connector) {
        super(connector, FIND_BY_ID_QUERY);
    }

    @Override
    public Optional<UserEntity> findByEmail(String email) {
        return findByParam(email, FIND_BY_EMAIL_QUERY, STRING_PARAM_SETTER);
    }

    @Override
    public void save(UserEntity entity) {

    }

    @Override
    public List<UserEntity> findAll(int page, int itemPerPage) {
        try (final PreparedStatement preparedStatement =
                     connector.getConnection().prepareStatement(FIND_ALL_QUERY)) {
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {
                List<UserEntity> userEntities = new ArrayList<>();
                while (resultSet.next()) {
                    final UserEntity optionalUserEntity = mapResultSetToEntity(resultSet);
                    userEntities.add(optionalUserEntity);
                }
                return userEntities;
            }

        } catch (SQLException e) {
            //log
            throw new DataBaseSqlRuntimeException("", e);
        }
    }

    @Override
    public long count() {
        return 0;
    }

    protected UserEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return UserEntity.builder()
                .withId(resultSet.getInt("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withTelephoneNumber(resultSet.getString("phone_number"))
                .build();
    }

    @Override
    public void update(UserEntity entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }
}
