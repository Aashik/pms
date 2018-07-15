package com.niftylife.stockapp.controller;

import com.niftylife.stockapp.dao.LoginDao;
import com.niftylife.stockapp.entity.Login;
import com.niftylife.stockapp.entity.LoginResponse;
import com.niftylife.stockapp.entity.Response;
import com.niftylife.stockapp.service.AccountService;
import com.niftylife.stockapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/")
public class LoginController {

//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private UserService userService;
    @Autowired
    private LoginDao loginDao;

    @RequestMapping(value = "api/login", method = RequestMethod.GET)
    @ResponseBody
    public String Login() {
        return "<h1>This is the home page for login page.</h1>";
    }

    @RequestMapping(value = "/saveLogin", method = RequestMethod.POST)
    public Response saveLogin(@RequestBody Login login){
        Login l = loginDao.save(login);
        Response response = new Response();
        if (l != null){
            response.setStatus("success");
            response.setMessage("successfully inserted ");
            response.setData(l);
            return response;
        }
        response.setStatus("error");
        response.setMessage("invalid request");
        response.setData(null);
        return response;
    }

    @RequestMapping(value = "/getAll{login_id}", method = RequestMethod.GET)
    public ResponseEntity<Response> getAll(){
       List<Login> loginList = loginDao.findAll();
       Response response = new Response();
        if (!loginList.isEmpty()) {
            response.setStatus("success");
            response.setMessage("successfully retrived");
            response.setData(loginList);
            return new ResponseEntity<Response>(response, HttpStatus.OK);
        }
       response.setStatus("error");
        response.setMessage("invalid request");
        response.setData(null);
        return new ResponseEntity<Response>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteLogin{login_id}", method = RequestMethod.GET)
    public Response deleteById(@PathVariable("login_id") Long login_id ){
        loginDao.deleteById(login_id);
        Response response = new Response();
        response.setStatus("success");
        response.setMessage("successfully deleted");
        response.setData(login_id);
        return response;

    }
}
