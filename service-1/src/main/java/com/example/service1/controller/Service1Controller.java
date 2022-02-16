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
                + " 1. git clone [주소: shift+insert]"
                +  "git branch junho"
                +"git checkout junho"
                +"2. git add . => 전체 변경한 내용이 전부 올라가는것."
                +"2. git add Service1Controller.java => 옆에 있는 파일만 local에 저장"
                +"3. git commit -m 'servicecontroller 변경'"
                +"4. git push origin junho"
                );
    }


}
