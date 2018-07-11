package com.niftylife.stockapp.dao;

import com.niftylife.stockapp.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductDaoImpl implements ProductCustomDao {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getByProductCode(String productCOde) {
        List<Product> productList = productDao.findAll();
       for(Product p : productList){
           if (p.getProductCode().equalsIgnoreCase(productCOde)){
               return p;
           }
       }
       return null;

    }


}
