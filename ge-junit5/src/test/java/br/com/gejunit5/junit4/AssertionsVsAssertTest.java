package br.com.gejunit5.junit4;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class AssertionsVsAssertTest {

	@Test
	public void shouldShowMessage() {
		Assert.assertTrue("Era false :/", false);
	}

	@Test
	public void shouldAssertAllNotShowingAllErrors() {
		List<String> strings = Arrays.asList("um", "dois");

	    Assert.assertEquals("a", strings.get(0));
	   	Assert.assertEquals("b", strings.get(1)); //Never printed
	}

}
