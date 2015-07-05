package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.validation.Validation;

public class InputValidatorTest {
	
	@Test
	public void testValidateFieldInputValid() {
		String input = "1 5";
		String input2 = "0 0";
		
		InputValidator validator = new InputValidator();
		Validation validation = validator.validatePositionInput(input);
		Validation validation2 = validator.validatePositionInput(input2);
		
		assertTrue(validation.isOk());
		assertTrue(validation2.isOk());
	}
	
	@Test
	public void testValidateFieldInputInvalid() {
		String inputWithLetter = "a 5";
		String inputWithSymbol = "^ 1";
		String inputWithoutSpace = "113";
		String inputSmaller = "11";
		String inputLarger = "1 1 ";
		
		InputValidator validator = new InputValidator();
		Validation validation = validator.validatePositionInput(inputWithLetter);
		Validation validation2 = validator.validatePositionInput(inputWithSymbol);
		Validation validation4 = validator.validatePositionInput(inputWithoutSpace);
		Validation validation3 = validator.validatePositionInput(inputSmaller);
		Validation validation5 = validator.validatePositionInput(inputLarger);
		
		assertFalse(validation.isOk());
		assertFalse(validation2.isOk());
		assertFalse(validation3.isOk());
		assertFalse(validation4.isOk());
		assertFalse(validation5.isOk());
	}
	
	@Test
	public void testValidateRoverInputValid() {
		String input = "1 2 N";
		String input2 = "3 1 E";
		String input3 = "0 0 W";
		String input4 = "5 5 S";
		
		InputValidator validator = new InputValidator();
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
		
		InputValidator validator = new InputValidator();
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
	
	@Test
	public void testValidateCommandInputValid() {
		String inputNoCommand = "";
		String inputOneCommand = "L";
		String inputAllCommandsOnce = "LMR";
		String inputAllCommandsTwice = "LLRMMR";
		
		InputValidator validator = new InputValidator();
		Validation validation = validator.validateCommandInput(inputNoCommand);
		Validation validation2 = validator.validateCommandInput(inputOneCommand);
		Validation validation3 = validator.validateCommandInput(inputAllCommandsOnce);
		Validation validation4 = validator.validateCommandInput(inputAllCommandsTwice);
		
		assertTrue(validation.isOk());
		assertTrue(validation2.isOk());
		assertTrue(validation3.isOk());
		assertTrue(validation4.isOk());
	}
	
	@Test
	public void testValidateCommandInputInvalid() {
		String inputWithInvalidLetter = "A";
		String inputWithSymbol = "&";
		String inputWithSpaces = "L R";
		
		InputValidator validator = new InputValidator();
		Validation validation = validator.validateCommandInput(inputWithInvalidLetter);
		Validation validation2 = validator.validateCommandInput(inputWithSymbol);
		Validation validation3 = validator.validateCommandInput(inputWithSpaces);
		
		assertFalse(validation.isOk());
		assertFalse(validation2.isOk());
		assertFalse(validation3.isOk());
	}
	
}
