package com.cimiento.mymusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@ImportResource(value = {"classpath:spring/core-context.xml"})
@EnableAutoConfiguration
@ComponentScan("com.cimiento")
public class Application {
	
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
