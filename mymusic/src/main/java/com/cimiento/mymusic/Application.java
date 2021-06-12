package com.cimiento.mymusic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


// Use these for tomcat or some other app server
//@ImportResource(value = {"classpath:spring/core-context.xml"})
//@EnableAutoConfiguration
//@ComponentScan("com.cimiento")

// If you do not want to allow 'inter-bean-references' within the configuration set the proxyBeanMethods to false
//@SpringBootApplication(proxyBeanMethods = false)

@SpringBootApplication
public class Application {
	
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
