package com.niftylife.stockapp.controller;


import com.niftylife.stockapp.dao.ProductDao;
import com.niftylife.stockapp.entity.Product;
import com.niftylife.stockapp.entity.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @RequestMapping(value = "api/updateProduct", method = RequestMethod.POST)
    public Response updateProduct(@RequestBody Product product){
        Product result = productDao.save(product);
        Response response = new Response();
        if (result != null){
            response.setStatus("success");
            response.setMessage("Data updated successfully");
            response.setData(result);
            return response;
        }
        response.setStatus("error");
        response.setMessage("Invalid request.. somethings wrong");
        response.setData(null);
        return response;
    }


    @RequestMapping(value = "api/getall", method = RequestMethod.GET)
    public ResponseEntity<Response> getAll() {
        List<Product> productList = productDao.findAll();
        Response response = new Response();
        if (!productList.isEmpty()) {
            response.setStatus("success");
            response.setMessage("all product data retrieved");
            response.setData(productList);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }
        response.setStatus("error");
        response.setMessage("sorry somethings wrong");
        response.setData(null);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
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

    @RequestMapping(value = "api/getByProductCode/{pCode}", method = RequestMethod.GET)
    public ResponseEntity<Response> getByProductCode(@PathVariable("pCode") String productCode){
        Product product = productDao.getByProductCode(productCode);
        Response response = new Response();
        if (product != null){
            response.setStatus("success");
            response.setMessage("Product retirived with code");
            response.setData(product);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }
        response = new Response("error", "something wrong", null);
        return new ResponseEntity<Response>(response, HttpStatus.OK);

    }
}
