package com.bulbul.examportal.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    /**
     * Fetch data as a rest template
     * Fetching data as a json format from api
     * */

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
