package com.niftylife.stockapp.dao;


import com.niftylife.stockapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {

}
