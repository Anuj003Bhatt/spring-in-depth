package com.anujbhatt.lil.sid.application;

import com.anujbhatt.lil.sid.application.config.ApplicationConfig;
import com.anujbhatt.lil.sid.application.service.OutputService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationUsingSpring {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        OutputService outputService = context.getBean(OutputService.class);

        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(500);

        }

    }
}
