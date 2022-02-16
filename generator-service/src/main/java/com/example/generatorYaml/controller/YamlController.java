package com.example.generatorYaml.controller;


import com.example.generatorYaml.generator.Binding_yaml;

import com.example.generatorYaml.vo.*;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class YamlController {
    private Environment env;
    private Binding_yaml binding_yaml;


    @Autowired
    public YamlController(Environment env, Binding_yaml binding_yaml){
        this.env =env;
        this.binding_yaml=binding_yaml;
    }

    @GetMapping("/health_check")
    public String status(){
        return String.format("It's Working in User Service"
                +", port(local.server.port)="+env.getProperty("local.server.port")
                +", port(server.port)="+env.getProperty("server.port")
                +", token secret="+env.getProperty("token.secret")
                +", token expiration time="+env.getProperty("token.expiration_time"));
    }

    //resource yml uri 주소 입력 - (rosurce uri)
    @PostMapping("/insertYaml")
    public void insertYaml(@RequestBody String uri){
        binding_yaml = new Binding_yaml(uri);
    }
    
    //맨뒤에 필터 추가 (Name, Args, BaseMessage, PreLogger,PostLogger)
    @PostMapping("/insertFilter")
    public void insertFilter(@RequestBody RequestFilter request){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestFilter requestFilter = mapper.map(request,RequestFilter.class);

        binding_yaml.insert_filter(requestFilter.getName(),
                requestFilter.getArgs(),
                requestFilter.getBaseMessage(),
                requestFilter.getPreLogger(),
                requestFilter.getPostLogger());

    }
    //특정위치에 필터 추가 - (특정필터이름, Name,Args, BaseMessage, PreLogger,PostLogger)
    @PostMapping("/insertFilter_pre")
    public void insertFilter_pre(@RequestBody RequestFilter_pre request_pre){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestFilter_pre requestFilter_pre = mapper.map(request_pre,RequestFilter_pre.class);

        binding_yaml.insert_filter(requestFilter_pre.getPrefilter_name(),
                requestFilter_pre.getName(),
                requestFilter_pre.getArgs(),
                requestFilter_pre.getBaseMessage(),
                requestFilter_pre.getPostLogger(),
                requestFilter_pre.getPostLogger());
    }
    // 맨뒤 필터 삭제
    @PostMapping("/deleteFilter")
    public void delete_filter(){
        binding_yaml.delete_filter();
    }
    // 특정필터 삭제 -(특정필터 Name)
    @PostMapping("/deleteFilter_target")
    public void delete_filter(@RequestBody String target){
        binding_yaml.delete_filter(target);
    }
    // 특정 필터 업데이터(특정필터 name, name, Args, BaseMessage, PreLogger,PostLogger)
    @PostMapping("/updateFilter")
    public void update_filter(@RequestBody RequestUpdate update){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestUpdate requestUpdate = mapper.map(update,RequestUpdate.class);
        binding_yaml.update_filter(requestUpdate.getPrefilter_name(),
                requestUpdate.getName(),
                requestUpdate.getArgs(),
                requestUpdate.getBaseMessage(),
                requestUpdate.getPreLogger(),
                requestUpdate.getPostLogger());
    }





    //라우터
    //맨뒤에 라우터 삽입 - (router_id, uri, Predicates)
    @PostMapping("/insertRouter")
    public void insertRouter(@RequestBody RequestRouter request){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestRouter requestRouter = mapper.map(request,RequestRouter.class);

        binding_yaml.insert_router(requestRouter.getId(),
                requestRouter.getUri(),
                requestRouter.getPredicates()
            ,requestRouter.getFilters());

    }

    //특정 위치에 라우터 삽입 - (특정라우터 id,router_id, uri, Predicates, filters)
    @PostMapping("/insertRouter_pre")
    public void insertRouter(@RequestBody RequestRouter_pre request){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestRouter_pre requestRouter_pre = mapper.map(request,RequestRouter_pre.class);

        binding_yaml.insert_router(requestRouter_pre.getPreNode_id(),
                requestRouter_pre.getId(),
                requestRouter_pre.getUri(),
                requestRouter_pre.getPredicates(),
                requestRouter_pre.getFilters());
    }

    // 맨뒤 라우터 삭제
    @PostMapping("/deleteRouter")
    public void delete_router(){
        binding_yaml.delete_router();
    }

    //특정 라우터 삭제 -(특정라우터 id)
    @PostMapping("/deleteRouter_target")
    public void delete_router(@RequestBody String target){
        binding_yaml.delete_filter(target);
    }

    //특정라우터 업데이트 - (특정라우터 id,router_id, uri)
    @PostMapping("/updateRouter")
    public void update_router(@RequestBody RequestUpdateRouter update){
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        RequestUpdateRouter requestUpdateRouter = mapper.map(update,RequestUpdateRouter.class);
        binding_yaml.update_router(requestUpdateRouter.getTarget_id(),
                requestUpdateRouter.getUpdate_id(),
                requestUpdateRouter.getUpdate_uri());
    }

    //결과 yaml 내보내기 -(결과 생성되어질 uri)
    @PostMapping("/createYaml")
    public void createYaml(@RequestBody String uri){
        binding_yaml.createYaml(uri);
    }



}
