package com.bank.dao.impl;

import com.bank.dao.AccountDao;
import com.bank.dao.ConnectorDB;
import com.bank.entity.AccountEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class AccountDaoImpl extends AbstractCrudDaoImpl<AccountEntity> implements AccountDao {
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM accounts WHERE id=?";

    public AccountDaoImpl(ConnectorDB connector) {
        super(connector, FIND_BY_ID_QUERY);
    }

    @Override
    public void save(AccountEntity entity) {

    }

    @Override
    public List<AccountEntity> findAll(int page, int itemsPerPage) {
        return Collections.emptyList();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void update(AccountEntity entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    protected AccountEntity mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        return new AccountEntity(resultSet.getInt("id"), null, resultSet.getInt("id"));

    }

    @Override
    public void transferMoney(Integer accountIdFrom, Integer accountIdTo, long money) {
        Connection connection = null;
        try {
            connection = connector.getConnection();
            connection.setAutoCommit(false);
            final PreparedStatement preparedStatement1 = connection.prepareStatement("SQL query");
            preparedStatement1.execute();
            //

            final PreparedStatement preparedStatement2 = connection.prepareStatement("SQL query");
            preparedStatement2.execute();

            connection.commit();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            if (connection!=null) {
                try {
                    connection.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
