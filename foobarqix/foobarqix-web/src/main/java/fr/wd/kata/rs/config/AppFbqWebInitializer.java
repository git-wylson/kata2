package fr.wd.kata.rs.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Classe permettant de configurer descripteur web.xml
 * @author wylson
 *
 */
public class AppFbqWebInitializer extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FbqAppConfig.class);
	}

}
