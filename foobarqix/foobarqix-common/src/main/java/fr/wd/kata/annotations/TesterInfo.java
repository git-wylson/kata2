package fr.wd.kata.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE) //on class level
@Target(ElementType.FIELD) //on field level
@Constraint(validatedBy = TesterInfoValidator.class)
public @interface TesterInfo {

	public enum Priority {
	   LOW, MEDIUM, HIGH
	}

	Priority priority() default Priority.MEDIUM;
	
	String[] tags() default "";
	
	String createdBy() default "wylson";
	
	String lastModified() default "18/10/2016";

}