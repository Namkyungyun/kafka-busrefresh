package com.example.generatorYaml.generator.obj;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Routes {
    private String id;
    private String uri;
    private ArrayList<String> predicates;
    private ArrayList<String> filters;
}