package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Login;
import com.niftylife.stockapp.entity.Response;
import com.niftylife.stockapp.entity.User;
import com.niftylife.stockapp.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginCustomeDaoImpl implements LoginCustomeDao {

    @Autowired
    private LoginService loginService;

    @Autowired
    private LoginCustomeDao loginCustomeDao;

    @Override
    public Login validate(String username, String password) {
       List<User> userList =loginCustomeDao.findAll();

    }
}
