package net.javaguide.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseEntity<?> saveLoggedInUser(@RequestParam String loginValue, HttpServletResponse response){
        Cookie cookie = new Cookie("reactLoggedInUser",loginValue);
        System.out.println(loginValue);
        // expires in 7 days
        cookie.setMaxAge(7 * 24 * 60 * 60);
        cookie.setSecure(true);
        // optional properties

        cookie.setHttpOnly(true);

        // add cookie to response
        response.addCookie(cookie);

        return ResponseEntity.ok("Connection successful");
    }

}