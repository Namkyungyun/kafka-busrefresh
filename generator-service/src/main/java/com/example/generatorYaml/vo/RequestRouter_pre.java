package com.example.generatorYaml.vo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class RequestRouter_pre {
    private String preNode_id;
    private String id;
    private String uri;
    private ArrayList<String> predicates = new ArrayList<String>();
    private ArrayList<String> filters = new ArrayList<String>();
}
