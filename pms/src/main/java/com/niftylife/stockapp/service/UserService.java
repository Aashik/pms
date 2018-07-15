package com.niftylife.stockapp.service;

import com.niftylife.stockapp.entity.User;

public interface UserService {

    User getByEmail(String email);
}
