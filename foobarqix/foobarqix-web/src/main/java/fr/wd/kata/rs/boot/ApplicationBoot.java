package fr.wd.kata.rs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.wd.kata.rs.config.AppConfig;

@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class, args);
    }
}