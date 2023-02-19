package com.anujbhatt.lil.sid.application;

import com.anujbhatt.lil.sid.application.service.GreetingService;
import com.anujbhatt.lil.sid.application.service.OutputService;
import com.anujbhatt.lil.sid.application.service.TimeService;

public class Application {

    public static void main(String[] args) throws Exception {
        GreetingService greetingService = new GreetingService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(greetingService, timeService, "Anuj");

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(5000);
        }
    }
}
