package fr.wd.kata.rs.config;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import fr.wd.kata.config.FbqServiceConfig;


@EnableAutoConfiguration
@ComponentScan(basePackages = { "fr.wd.kata.rs" })
@Import({ FbqServiceConfig.class /*,FbqSecurityConfig.class*/, WebConfig.class})
public class FbqAppConfig {

}
