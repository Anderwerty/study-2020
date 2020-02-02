package com.bank.dao;

import com.bank.entity.AccountEntity;

public interface AccountDao extends CrudPageableDao<AccountEntity> {

    void transferMoney(Integer accountIdFrom, Integer accountIdTo, long money);
}
