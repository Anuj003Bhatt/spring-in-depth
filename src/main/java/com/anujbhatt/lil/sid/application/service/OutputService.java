package com.anujbhatt.lil.sid.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OutputService {
    @Value("${app.name}")
    private String name;

    private GreetingService greetingService;
    private TimeService timeService;

    public OutputService(GreetingService greetingService, TimeService timeService){
        this.greetingService = greetingService;
        this.timeService = timeService;
    }

    public void generateOutput(){
        String output = timeService.getCurrentTime() + " " + greetingService.getGreeting(name);
        System.out.println(output);
    }
}
