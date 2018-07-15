package com.niftylife.stockapp.controller;

import com.niftylife.stockapp.dao.AccountCustomDao;
import com.niftylife.stockapp.dao.AccountDao;
import com.niftylife.stockapp.entity.Account;
import com.niftylife.stockapp.entity.LoginResponse;
import com.niftylife.stockapp.entity.Response;
import com.niftylife.stockapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public Response saveLogin(@RequestBody Account account) {
        Response response = new Response();

          boolean checkdup = accountService.checkDuplication(account.getEmail());

          if (checkdup) {
          Account a = accountService.save(account);
          response.setStatus("success");
          response.setMessage("account created successfully");
          response.setData(a);
          return response;
          }
          response.setStatus("error");
          response.setMessage("duplicate email found.");
          response.setData(null);
          return response;
    }

//    @RequestMapping(value = "/updateAccount", method = RequestMethod.POST)
//    public Response updateAccount(@RequestBody Account account) {
//        Account result = accountDao.save(account);
//        Response response = new Response();
//        if (result != null) {
//            response.setStatus("success");
//            response.setMessage("successfully updated");
//            response.setData(result);
//            return response;
//        }
//        response.setStatus("error");
//        response.setMessage("invalid resquest");
//        response.setData(null);
//        return response;
//    }

//    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
//    public ResponseEntity<Response> getAll(){
//        List<Account> accountList =accountDao.findAll();
//        Response response = new Response();
//        if (!accountList.isEmpty()){
//            response.setStatus("success");
//            response.setMessage("Successfully retrived");
//            response.setData(accountList);
//            return new ResponseEntity<Response>(response,HttpStatus.OK);
//        }
//        response.setStatus("error");
//        response.setMessage("invalid request");
//        response.setData(null);
//        return new ResponseEntity<Response>(response, HttpStatus.OK);
//    }
//
//    @RequestMapping(value = "/delete/{account_id}", method = RequestMethod.GET)
//    public Response deleteAccount(@PathVariable ("account_id") Long account_id){
//        accountDao.deleteById(account_id);
//        Response response = new Response();
//        response.setStatus("success");
//        response.setMessage("successfully deleted");
//        response.setData(account_id);
//        return response;
//
//    }
}
