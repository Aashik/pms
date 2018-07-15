package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginDao extends JpaRepository<Login, Long> {
}

//create LoginCustomDao  -- insert(Login login), validate (String username , String password)
//create LoginCustomDaoImpl -- implement

//create LoginService

//login controller

// "/api/login"
// check validate
//if true insert in login and give success status