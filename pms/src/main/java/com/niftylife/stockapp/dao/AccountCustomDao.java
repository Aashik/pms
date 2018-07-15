package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Account;

public interface AccountCustomDao {
    boolean isEmpty(Account account);
    boolean checkDuplicate(String email);
  Account getByEmail(String email);
}
