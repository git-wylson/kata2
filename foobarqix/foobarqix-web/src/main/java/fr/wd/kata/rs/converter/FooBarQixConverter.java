package fr.wd.kata.rs.converter;

import org.springframework.stereotype.Component;

import com.google.common.base.Converter;

import fr.wd.kata.business.domain.FooBarQix;
import fr.wd.kata.rs.model.FooBarQixRest;

/**
 * This class convert business model to transfert object data
 * @author wylson dibinga
 */
@Component
public class FooBarQixConverter extends Converter<FooBarQixRest, FooBarQix> {

	@Override
	protected FooBarQixRest doBackward(FooBarQix foo) {
		FooBarQixRest dto = null;
		if (foo != null) {
			dto = new FooBarQixRest();
			dto.setNumber(foo.getIndex());
			dto.setResult(foo.getResult());
		}
		return dto;
	}

	@Override
	protected FooBarQix doForward(FooBarQixRest dto) {
		FooBarQix foo = null;
		if (dto != null) {
			foo = new FooBarQix(dto.getNumber(), dto.getResult());
		}
		return foo;
	}
}
