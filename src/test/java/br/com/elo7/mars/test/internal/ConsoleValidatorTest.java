package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.elo7.mars.validation.ConsoleValidator;
import br.com.elo7.mars.validation.Validation;

public class ConsoleValidatorTest {
	
	@Test
	public void testValidateFieldInputInvalid() {
		String inputWithLetter = "a 5";
		String inputWithSymbol = "^ 1";
		String inputWithoutSpace = "113";
		String inputSmaller = "11";
		String inputLarger = "1 1 ";
		
		ConsoleValidator validator = new ConsoleValidator();
		Validation validation = validator.validateFieldInput(inputWithLetter);
		Validation validation2 = validator.validateFieldInput(inputWithSymbol);
		Validation validation4 = validator.validateFieldInput(inputWithoutSpace);
		Validation validation3 = validator.validateFieldInput(inputSmaller);
		Validation validation5 = validator.validateFieldInput(inputLarger);
		
		assertFalse(validation.isOk());
		assertFalse(validation2.isOk());
		assertFalse(validation3.isOk());
		assertFalse(validation4.isOk());
		assertFalse(validation5.isOk());
	}
	
	@Test
	public void testValidateFieldInputValid() {
		String input = "1 5";
		String input2 = "0 0";
		
		ConsoleValidator validator = new ConsoleValidator();
		Validation validation = validator.validateFieldInput(input);
		Validation validation2 = validator.validateFieldInput(input2);
		
		assertTrue(validation.isOk());
		assertTrue(validation2.isOk());
	}
	
	@Test
	public void testValidateRoverInputValid() {
		String input = "1 2 N";
		String input2 = "3 1 E";
		String input3 = "0 0 W";
		String input4 = "5 5 S";
		
		ConsoleValidator validator = new ConsoleValidator();
		Validation validation = validator.validateRoverInput(input);
		Validation validation2 = validator.validateRoverInput(input2);
		Validation validation3 = validator.validateRoverInput(input3);
		Validation validation4 = validator.validateRoverInput(input4);
		
		assertTrue(validation.isOk());
		assertTrue(validation2.isOk());
		assertTrue(validation3.isOk());
		assertTrue(validation4.isOk());
	}
	
	@Test
	public void testValidateRoverInputInvalid() {
		String inputWithLetterOnAxisX = "N 2 N";
		String inputWithLetterOnAxisY = "3 E E";
		String inputWithSymbolOnAxisX = "~ 2 E";
		String inputWithSymbolOnAxisY = "3 ^ E";
		String inputWithInvalidDirectionLetter = "3 2 I";
		String inputWithNumberOnDirection = "3 2 3";
		String inputWithSymbolOnDirection = "3 2 @";
		String inputSmaller = "1 1 ";
		String inputLarger = "1 1 1 ";
		
		ConsoleValidator validator = new ConsoleValidator();
		Validation validation = validator.validateRoverInput(inputWithLetterOnAxisX);
		Validation validation2 = validator.validateRoverInput(inputWithLetterOnAxisY);
		Validation validation3 = validator.validateRoverInput(inputWithSymbolOnAxisX);
		Validation validation4 = validator.validateRoverInput(inputWithSymbolOnAxisY);
		Validation validation5 = validator.validateRoverInput(inputWithInvalidDirectionLetter);
		Validation validation6 = validator.validateRoverInput(inputWithNumberOnDirection);
		Validation validation7 = validator.validateRoverInput(inputWithSymbolOnDirection);
		Validation validation8 = validator.validateRoverInput(inputSmaller);
		Validation validation9 = validator.validateRoverInput(inputLarger);
		
		assertFalse(validation.isOk());
		assertFalse(validation2.isOk());
		assertFalse(validation3.isOk());
		assertFalse(validation4.isOk());
		assertFalse(validation5.isOk());
		assertFalse(validation6.isOk());
		assertFalse(validation7.isOk());
		assertFalse(validation8.isOk());
		assertFalse(validation9.isOk());
	}
	
}