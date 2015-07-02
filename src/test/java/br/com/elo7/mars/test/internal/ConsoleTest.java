package br.com.elo7.mars.test.internal;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import br.com.elo7.mars.console.Console;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.validation.ConsoleValidator;

public class ConsoleTest {
	
	@Test
	public void testObtainFieldWithValidInput() {
		//TODO mock validator and console.
		String fieldEndPosition = "5 6";
		ByteArrayInputStream in = new ByteArrayInputStream(
				fieldEndPosition.getBytes());
		Scanner scanner = new Scanner(in);
		
		ConsoleValidator validator = new ConsoleValidator();
		Console console = new Console(scanner, validator);
		Field field = console.obtainField();
		
		assertNotNull(field);
		assertEquals(5, field.getArea().getAxisX());
		assertEquals(6, field.getArea().getAxisY());
	}
	
	//TODO testObtainRover

}
