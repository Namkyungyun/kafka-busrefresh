package com.example.generatorYaml.generator;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

// List를 구성하는 Node 클래스
@Data
@Component
class ListNode_routes{
    private String id;
    private String uri;
    private ArrayList<String> predicates = new ArrayList<String>();
    private ArrayList<String> filters = new ArrayList<String>();
    public ListNode_routes link;    // 다른 노드를 참조할 링크 노드

    public ListNode_routes() {
        this.id = null;
        this.uri = null;
        this.predicates = null;
        this.filters = null;
        this.link = null;
    }

    public ListNode_routes(String id,String uri,ArrayList<String> predicates,ArrayList<String> filters) {
        this.id = id;
        this.uri = uri;
        this.predicates = predicates;
        this.filters = filters;
        this.link = null;
    }

    public ListNode_routes(String id,String uri,ArrayList<String> predicates,ArrayList<String> filters,ListNode_routes link) {
        this.id = id;
        this.uri = uri;
        this.predicates = predicates;
        this.filters = filters;
        this.link = link;
    }

}
