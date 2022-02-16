package com.example.infoservice.controller;

import com.example.infoservice.r2dbc.InfoRepository;
import com.example.infoservice.r2dbc.Urls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/info")
@RestController
public class InfoController {

    private InfoRepository infoRepository;
    private Environment env;

    @Autowired
    public InfoController(InfoRepository infoRepository, Environment env)
    {
        this.infoRepository = infoRepository;
        this.env = env;
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in Info Service\n"
                + "current port = " + env.getProperty("local.server.port")
                + "\nbusrefresh check = " + env.getProperty("text.change")
                + "\nYou can check the yaml_generator guide!\n"
                + "Try check using GetMapping and url(/url)");
    }

    @GetMapping
    public Flux<Urls> getUrls() {
        return infoRepository.findAll();
    }
    /** {ex) /info/filter/create, /info/router/create} **/
    @GetMapping("/{select}/{crud}")
    public Flux<Urls> getUser(@PathVariable("select") String select, @PathVariable("crud") String crud) {
        return infoRepository.findByUrlContainingAndCrud(select,crud);
    }

    @PostMapping
    public Mono<Urls> save(@RequestBody Urls urls) {
        return infoRepository.save(urls);
    }


    @DeleteMapping("/delete/{urlName}")
    public Mono<Void> removeMember(@PathVariable String urlName) {
        return Mono.just(urlName)
                .flatMap(infoRepository::findFirstByUrlContaining)
                .flatMap(infoRepository::deleteById);
    }


}
