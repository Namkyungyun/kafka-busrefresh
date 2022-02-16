package com.example.service2.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-2/")
public class Service2Controller {
    private Environment env;

    @Autowired
    public Service2Controller(Environment env){
        this.env =env;

    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service"
                +", port(local.server.port)="+env.getProperty("local.server.port")
                +", port(server.port)="+env.getProperty("server.port"));
    }


}
