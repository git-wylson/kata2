package fr.wd.kata.rs.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.wd.kata.rs.config.FbqAppConfig;

@SpringBootApplication
public class FbqAppBoot {

    public static void main(String[] args) {
        SpringApplication.run(FbqAppConfig.class, args);
    }
}