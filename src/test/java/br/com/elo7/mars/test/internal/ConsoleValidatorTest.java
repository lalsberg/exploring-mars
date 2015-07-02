package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.elo7.mars.validation.ConsoleValidator;
import br.com.elo7.mars.validation.Validation;

public class ConsoleValidatorTest {
	
	@Test
	public void testValidateFieldEndPositionInvalid() {
		ConsoleValidator validator = new ConsoleValidator();
		String inputWithLetter = "a 5";
		String inputWithSymbol = "^ 1";
		String inputWithoutSpace = "113";
		String inputSmaller = "11";
		String inputLarger = "1 1 ";
		
		Validation validation = validator.validateFieldEndPosition(inputWithLetter);
		Validation validation2 = validator.validateFieldEndPosition(inputWithSymbol);
		Validation validation4 = validator.validateFieldEndPosition(inputWithoutSpace);
		Validation validation3 = validator.validateFieldEndPosition(inputSmaller);
		Validation validation5 = validator.validateFieldEndPosition(inputLarger);
		
		assertFalse(validation.isOk());
		assertFalse(validation2.isOk());
		assertFalse(validation3.isOk());
		assertFalse(validation4.isOk());
		assertFalse(validation5.isOk());
	}
	
	@Test
	public void testValidateFieldEndPositionValid() {
		ConsoleValidator validator = new ConsoleValidator();
		String input = "1 5";
		String input2 = "0 0";
		
		Validation validation = validator.validateFieldEndPosition(input);
		Validation validation2 = validator.validateFieldEndPosition(input2);
		
		assertTrue(validation.isOk());
		assertTrue(validation2.isOk());
	}

}
