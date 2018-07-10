package com.niftylife.stockapp.controller;


import com.niftylife.stockapp.dao.ProductDao;
import com.niftylife.stockapp.entity.Product;
import com.niftylife.stockapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ListResourceBundle;


@RestController
@RequestMapping(value = "/")
public class ProductController {

    private ProductDao productDao;

    @Autowired
    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    @ResponseBody
    public String productHome() {
        return "<h1>This is the home page for Product detials.</h1>";
    }


    @RequestMapping(value = "api/saveProduct", method = RequestMethod.POST)
    public Response saveProduct(@RequestBody Product product) {
        Product p = productDao.save(product);
        if (p != null) {
            Response response = new Response();
            response.setStatus("success");
            response.setMessage("this is working great");
            response.setData(p);
            return response;
        }
        Response response = new Response();
        response.setStatus("Invalid request");
        response.setMessage("Error");
        response.setData(null);
        return response;

    }

    @RequestMapping(value = "api/getall", method = RequestMethod.GET)
    public Response getAll() {
        List<Product> productList = productDao.findAll();
        Response response = new Response();
        if (!productList.isEmpty()) {
            response.setStatus("success");
            response.setMessage("all product data retrieved");
            response.setData(productList);
            return response;
        }
        response.setStatus("error");
        response.setMessage("sorry somethings wrong");
        response.setData(null);
        return response;
    }

    @RequestMapping(value = "api/delete/{productId}", method = RequestMethod.GET)
    public Response deleteProduct(@PathVariable("productId")Long productId) {
        productDao.deleteById(productId);
        Response response = new Response();
        response.setStatus("success");
        response.setMessage("Successfully deleted"+ productId);
        response.setData(null);
        return response;
    }
}
