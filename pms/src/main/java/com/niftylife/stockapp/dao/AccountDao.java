package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}
