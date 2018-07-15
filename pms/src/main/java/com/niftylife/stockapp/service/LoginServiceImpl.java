package com.niftylife.stockapp.service;

import com.niftylife.stockapp.dao.LoginCustomeDao;
import com.niftylife.stockapp.dao.LoginCustomeDaoImpl;
import com.niftylife.stockapp.dao.LoginDao;
import com.niftylife.stockapp.entity.Login;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private LoginCustomeDao loginCustomeDao;

    @Override
    public int insert(Login l) {
        return loginCustomeDao.insert(l);
    }

    @Override
    public Login validate(String username, String password) {
        return loginCustomeDao.validate(username,password);
    }
}
