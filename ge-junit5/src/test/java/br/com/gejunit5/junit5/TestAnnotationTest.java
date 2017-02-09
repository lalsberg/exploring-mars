package br.com.gejunit5.junit5;


import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestAnnotationTest {

	@Test
	public void shouldThrowExceptionWithMessage() {
		Throwable ex = Assertions.assertThrows(RuntimeException.class, this::throwException);
		Assertions.assertEquals("This shouldn't happen.", ex.getMessage());
	}

	@Test
	public void shouldFailOnTimeout() {
		Assertions.assertTimeout(Duration.ofMillis(1L), this::waitTwoMillis);
	}

	@Test
	public void shouldNotFailWithoutTimeout() {
		Assertions.assertTimeout(Duration.ofMillis(20L), this::waitTwoMillis);
	}

	private void throwException() {
		throw new RuntimeException("This shouldn't happen.");
	}

	private void waitTwoMillis() {
		try {
			Thread.sleep(2L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
