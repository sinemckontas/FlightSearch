package com.amadeus.casestudy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {

    @RequestMapping("/")
    public String getFlight(){
        return "Hi you're good";
    }

}
