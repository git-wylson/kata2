package fr.wd.kata.rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This class defines the access point to the application
 * @author wylson dibinga
 */
//@Controller
//@RequestMapping("/kata")
public class IndexController {

	//@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		return "default";
	}

}
