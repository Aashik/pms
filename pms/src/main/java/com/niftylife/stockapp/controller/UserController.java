package com.niftylife.stockapp.controller;

import com.niftylife.stockapp.dao.UserDao;
import com.niftylife.stockapp.entity.Response;
import com.niftylife.stockapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/addUser", method = RequestMethod.POST)
    public Response addUser(@RequestBody User user) {
        User u = userDao.save(user);
        if (u != null) {
            Response response = new Response();
            response.setStatus("success");
            response.setMessage("Successfully saved the record");
            response.setData(u);
            return response;
        }
        Response response = new Response();
        response.setStatus("Error");
        response.setMessage("Invalid response pls try again");
        response.setData(null);
        return null;
    }

    @RequestMapping(value = "api/allUser", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> userList = userDao.findAll();
        Response response = new Response();
        if (!userList.isEmpty()) {
            response.setStatus("success");
            response.setMessage("successfully listed");
            response.setData(userList);
            return userList;
        }
        return null;
    }

   // @RequestMapping(value = "api/deleteUser/{id}", method = RequestMethod.GET)
    // public Response deleteUser(@PathVariable("id") Long id){
    //    userDao.deleteById(id);
    //    Response response = new Response();
    //    response.setStatus("success");
    //    response.setMessage("Successfully deleted" + id);
    //    response.setData(null);
    //    return response;
   // }

}

