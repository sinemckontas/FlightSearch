package com.amadeus.casestudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class CasestudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }

}
