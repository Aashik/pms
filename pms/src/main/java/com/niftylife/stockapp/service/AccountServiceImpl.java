package com.niftylife.stockapp.service;

import com.niftylife.stockapp.dao.AccountCustomDao;
import com.niftylife.stockapp.dao.AccountDao;
import com.niftylife.stockapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountDao accountDao;
    @Autowired
    private AccountCustomDao accountCustomDao;

    @Override
    public boolean isEmpty(Account a) {
        return false;
    }

    @Override
    public boolean checkDuplication(String email) {
        return  accountCustomDao.checkDuplicate(email);
    }

    @Override
    public Account getByEmail(String email) {
        return null;
    }

    @Override
    public Account save(Account a) {
        return accountDao.save(a);
    }
}