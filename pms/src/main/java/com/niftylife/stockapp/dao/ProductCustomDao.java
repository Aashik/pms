package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Product;

public interface ProductCustomDao {
    Product getByProductCode(String productCode);
}
