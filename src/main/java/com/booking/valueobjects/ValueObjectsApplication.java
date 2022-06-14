package com.booking.valueobjects;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValueObjectsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValueObjectsApplication.class, args);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("booking-value-objects")
                .packagesToScan("com.booking.valueobjects")
                .build();
    }
}
