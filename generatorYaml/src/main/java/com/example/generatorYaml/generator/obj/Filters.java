package com.example.generatorYaml.generator.obj;

import lombok.Data;


@Data
public class Filters {
    private String name;
    private String args;
    private String baseMessage;
    private String preLogger;
    private String postLogger;
}
