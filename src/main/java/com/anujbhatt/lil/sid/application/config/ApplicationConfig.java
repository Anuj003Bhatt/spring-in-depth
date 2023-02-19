package com.anujbhatt.lil.sid.application.config;

import com.anujbhatt.lil.sid.application.service.GreetingService;
import com.anujbhatt.lil.sid.application.service.OutputService;
import com.anujbhatt.lil.sid.application.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ApplicationConfig {

    @Value("${app.greeting}")
    private String greeting;

    @Value("${app.name}")
    private String name;

    @Value("#{new Boolean(environment['spring.profiles.active']!='dev')}")
    private boolean is24;

    @Autowired
    private GreetingService greetingService;

    @Autowired
    private TimeService timeService;

    @Bean
//    @Profile("!dev")
    public TimeService timeService(){
        return new TimeService(is24);
    }

//    @Bean
//    @Profile("!dev")
//    public TimeService timeService12(){
//        return new TimeService(false);
//    }

    @Bean
    public GreetingService greetingService() {
        return new GreetingService(greeting);
    }

    @Bean
    public OutputService outputService(){
        return new OutputService(greetingService, timeService, name);
    }
}
