package br.com.gejunit5.junit4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestAnnotationTest {

	@Test(expected = RuntimeException.class)
	public void shouldPassOnExpectedException() {
		throw new RuntimeException();
	}

	@Test(timeout = 1L)
	public void shouldFailOnTimeout() {
		try {
			TimeUnit.MILLISECONDS.sleep(2L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(timeout = 20L)
	public void shouldNotFailWithoutTimeout() {
	}

}
