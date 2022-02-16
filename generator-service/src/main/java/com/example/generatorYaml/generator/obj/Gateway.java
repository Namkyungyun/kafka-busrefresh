package com.example.generatorYaml.generator.obj;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;

@Data
public class Gateway {
    private ArrayList<Filters> filters;
    private ArrayList<Routes> routes;
}