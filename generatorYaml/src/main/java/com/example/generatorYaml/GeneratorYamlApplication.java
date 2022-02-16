package com.example.generatorYaml;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorYamlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeneratorYamlApplication.class, args);
//        Binding_yaml binding_yaml = new Binding_yaml("resource.yml");
//        binding_yaml.createYaml("C:/Users/USER/git-repo-yaml-generator/yaml-generator/config-repo/resource.yml");
    }

}
