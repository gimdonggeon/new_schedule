package com.kdg.schedulewithjpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SchedulewithjpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulewithjpaApplication.class, args);
    }

}
