package com.amadeus.casestudy;

import com.amadeus.casestudy.model.Flight;
import com.amadeus.casestudy.repository.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication()
@EnableScheduling
public class CasestudyApplication {

    private final FlightRepository flightRepository;

    public CasestudyApplication(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CasestudyApplication.class, args);
    }

    @Scheduled(cron = "0 59 23 * * ?") //every day at 23:59
    public void scheduleTaskUsingCronExpression() {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://658b457aba789a962238a039.mockapi.io/api/v1/flight";
        Flight[] apiResults = restTemplate.getForObject(apiUrl, Flight[].class);
        if (apiResults == null) {
            throw new RuntimeException("API request failed!");
        }
        flightRepository.saveAll(Arrays.stream(apiResults).toList());
    }

}

