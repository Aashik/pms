package com.niftylife.stockapp.dao;


import com.niftylife.stockapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends MongoRepository<User, Long> {

}