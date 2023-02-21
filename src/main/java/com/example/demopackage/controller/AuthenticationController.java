package com.example.demopackage.controller;

import com.example.demopackage.jwt.security.UserCredentials;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/authen")
public class AuthenticationController {

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public static void login(@RequestBody UserCredentials req){
        //get jwt token from header
    }
}
