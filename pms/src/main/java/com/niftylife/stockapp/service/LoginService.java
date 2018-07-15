package com.niftylife.stockapp.service;

import com.niftylife.stockapp.entity.Login;

import java.util.List;

public interface LoginService {
    int insert(Login l);
    Login validate(String username, String password);
}
