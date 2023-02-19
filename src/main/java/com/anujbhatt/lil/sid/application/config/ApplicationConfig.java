package com.anujbhatt.lil.sid.application.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.anujbhatt.lil.sid")
public class ApplicationConfig {

}
