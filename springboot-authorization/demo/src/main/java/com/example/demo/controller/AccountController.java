package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins="http://localhost:3000", allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/account")
public class AccountController {

    @GetMapping
    public String getLoggedInUser(@CookieValue(name = "reactLoggedInUser") String account){
        return  account;
    }

    //build create employee REST API
    @PostMapping
    public ResponseEntity<?> saveLoggedInUser(@RequestParam String  loginValue, HttpServletResponse response){
        Cookie cookie = new Cookie("reactLoggedInUser",loginValue);
        if(loginValue!=""){
            cookie.setMaxAge(7 * 24 * 60 * 60);
        } else {
            cookie.setMaxAge(-1);
        }
        cookie.setSecure(true);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok("Connection successful");
    }

}