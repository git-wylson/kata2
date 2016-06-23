package fr.wd.kata.rs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.wd.kata.rs.config.AppFbqConfig;

@SpringBootApplication
public class AppFbqBoot {

    public static void main(String[] args) {
        SpringApplication.run(AppFbqConfig.class, args);
    }
}