package com.example.service1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-1/")
public class Service1Controller {
    private Environment env;

    @Autowired
    public Service1Controller(Environment env){
        this.env =env;

    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service"
                +", port(local.server.port)="+env.getProperty("local.server.port")
                +", port(server.port)="+env.getProperty("server.port")
                +", token secret="+env.getProperty("token.secret")
                +", token expiration time="+env.getProperty("token.expiration_time"));
    }


}
