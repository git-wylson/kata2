package fr.wd.kata.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class TesterInfoValidator implements ConstraintValidator<TesterInfo, Object> {

	 

	@Override
	public void initialize(TesterInfo constraintAnnotation) {

	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (value != null) {
			 
		}
		return false;
	}

}
