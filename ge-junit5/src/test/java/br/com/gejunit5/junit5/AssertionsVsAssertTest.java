package br.com.gejunit5.junit5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AssertionsVsAssertTest {

	@Test
	public void shouldShowMessage() {
		//Os primeiros argumentos serao sempre expected e value, depois a mensagem optional
		Assertions.assertTrue(false, "Era false :/");
	}

	@Test
	public void shouldCreateMessageLazily() {
		//Os primeiros argumentos serao sempre expected e value, depois a mensagem optional
		Assertions.assertFalse(false, () -> "Essa mensagem eh criada lazy para evitar mensagens complexas criadas desnecessariamente. \"performance\"");
	}

	@Test
	public void shouldAssertAllShowingAllErrors() {
		List<String> strings = Arrays.asList("um", "dois");

	    Assertions.assertAll("developer",
	   		 () -> Assertions.assertEquals("a", strings.get(0)),
	   		 () -> Assertions.assertEquals("b", strings.get(1))
	    );
	}

}
