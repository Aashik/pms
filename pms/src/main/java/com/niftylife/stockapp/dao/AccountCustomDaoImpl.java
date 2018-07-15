package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountCustomDaoImpl implements AccountCustomDao {

    @Autowired
    private AccountDao accountDao;

    @Override
    public boolean isEmpty(Account account) {
        return false;
    }

    @Override
    public boolean checkDuplicate(String email) {
        List<Account> accountList = accountDao.findAll();
        for(Account a : accountList){
            if (a.getEmail().equals(email)){
                return false;
            }
        }
        return true;
    }

    @Override
    public Account getByEmail(String email) {
        return null;
    }
}
