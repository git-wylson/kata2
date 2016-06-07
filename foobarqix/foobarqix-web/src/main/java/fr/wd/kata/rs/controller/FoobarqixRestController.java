package fr.wd.kata.rs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import fr.wd.kata.business.services.IFoobarqixService;
import fr.wd.kata.domain.FooBarQix;
import fr.wd.kata.exceptions.BusinessException;
import fr.wd.kata.rs.converter.FooBarQixConverter;
import fr.wd.kata.rs.domain.FooBarQixRest;
import fr.wd.kata.rs.utils.URI;

/**
 * This class is the service rest for application
 * @author wylson
 */
@RestController
public class FoobarqixRestController {

	@Autowired
	private IFoobarqixService foobarqixService;

	@Autowired
	private FooBarQixConverter converter;

	/**
	 * This method retrieve all results
	 * @return ResponseEntity<List<String>>
	 */
	@RequestMapping(value = URI.FOOBARQIX, method = RequestMethod.GET)
	public ResponseEntity<List<FooBarQixRest>> listAllNumbers() throws BusinessException {
		List<FooBarQix> results = foobarqixService.calculteNumber(100);
		List<FooBarQixRest> restResults = Lists.newArrayList(converter.reverse().convertAll(results));
		if (results.isEmpty()) {
			// we return HttpStatus.NOT_FOUND
			return new ResponseEntity<List<FooBarQixRest>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<FooBarQixRest>>(restResults, HttpStatus.OK);
	}
}
