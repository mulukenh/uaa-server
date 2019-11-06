package com.wcs.legalization.uaaserver.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Payload;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordConfirm {
	String message() default "Password do not match";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
