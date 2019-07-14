package com.zephyr.packages.scaner.annotations;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value={METHOD,ElementType.TYPE})
public @interface MyFirstAnnotation {

	String name() default"";
	String[] value() default{};
}
