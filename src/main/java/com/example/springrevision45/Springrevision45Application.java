package com.example.springrevision45;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
public class Springrevision45Application {

    public static void main(String[] args) {
        SpringApplication.run(Springrevision45Application.class, args);
    }

}
