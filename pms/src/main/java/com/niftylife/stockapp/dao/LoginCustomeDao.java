package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;

public interface LoginCustomeDao {
    Login validate(String username, String password);
}



//create LoginCustomDao  -- insert(Login login), validate (String username , String password)
//create LoginCustomDaoImpl -- implement