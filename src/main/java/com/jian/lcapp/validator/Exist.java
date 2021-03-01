package com.jian.lcapp.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {EmailExist.class})
public @interface Exist {
	
	String message() default "This email has exist!";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
}

