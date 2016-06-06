package fr.wd.kata.rs.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import fr.wd.kata.config.ServicesConfig;


@EnableAutoConfiguration
@ComponentScan(basePackages = { "fr.wd.kata.rs" , "hello"})
@Import({ ServicesConfig.class })
public class ApplicationConfig {

}
