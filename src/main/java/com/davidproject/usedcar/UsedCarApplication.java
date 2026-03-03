package com.davidproject.usedcar;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class UsedCarApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UsedCarApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }

    @Bean
    ApplicationRunner showProps(Environment env) {
        return args -> {
            System.out.println("VAULT URL: " + env.getProperty("spring.datasource.url"));
            System.out.println("VAULT USER: " + env.getProperty("spring.datasource.username"));
        };
    }
}
