package com.innso.exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@SpringBootApplication
public class ApiExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiExerciseApplication.class, args);
    }

}
