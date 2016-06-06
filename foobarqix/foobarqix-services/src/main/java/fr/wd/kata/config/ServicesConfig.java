package fr.wd.kata.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("fr.wd.kata.business") // search the fr.wd.kata.business package for @Component classes
public class ServicesConfig {
}