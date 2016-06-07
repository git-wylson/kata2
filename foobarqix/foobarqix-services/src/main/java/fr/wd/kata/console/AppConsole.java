package fr.wd.kata.console;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import fr.wd.kata.business.services.IFoobarqixService;
import fr.wd.kata.config.ServicesConfig;
import fr.wd.kata.domain.FooBarQix;

/**
 * Main console test.
 * @author wylson dibinga
 */
public class AppConsole {

	public static void main(String[] args) {
		// We get the spring context for application.
		SpringApplication app = new SpringApplication(ServicesConfig.class);
		app.setLogStartupInfo(false);
		 
		ConfigurableApplicationContext context = app.run(args);
		
		// We define our Business service interface which contains the foobarqix method.
		IFoobarqixService foo =   context.getBean(IFoobarqixService.class);

		// We calculte and print numbers from 1 to 100
		List<FooBarQix> results = foo.calculteNumber(100);
		results.forEach(fbq -> System.out.println(fbq.toString()));		 
	}
}
