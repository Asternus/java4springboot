package com.example.java4springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Java4springbootApplication {

    public static void main(String[] args) {

        //without args
        /*SpringApplication application = new SpringApplication(Java4springbootApplication.class);
        application.setAddCommandLineProperties(false);
        application.run(args);*/

   /*     SpringApplication springApplication = new SpringApplication(Java4springbootApplication.class);
        springApplication.setAdditionalProfiles("dev");
        springApplication.run(args);*/

        SpringApplication.run(Java4springbootApplication.class, args);
    }

}
