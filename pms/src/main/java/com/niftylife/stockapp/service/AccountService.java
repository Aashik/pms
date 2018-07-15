package com.niftylife.stockapp.service;

import com.niftylife.stockapp.entity.Account;

import java.util.List;

public interface AccountService {

    boolean isEmpty(Account a);
    boolean checkDuplication(String email);
    Account getByEmail(String email);
    Account save(Account a);

}
