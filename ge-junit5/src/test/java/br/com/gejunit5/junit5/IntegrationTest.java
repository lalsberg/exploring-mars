package br.com.gejunit5.junit5;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * We define a custom annotation @IntegrationTest that:
 * - stands in for '@Test' so that the method gets executed
 * - has the tag "integration" so we can filter by that,
 *   e.g. when running tests from the command line
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Test
@Tag("integration")
public @interface IntegrationTest { }