package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.validation.InputValidator;

public class ParserTest {
	
	@Test
	public void testParseField() throws ParseException {
		String fieldInput = "5 3";
		
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		Field field = parser.parseField(fieldInput);
		
		assertNotNull(field);
		assertEquals(5, field.getArea().getAxisX());
		assertEquals(3, field.getArea().getAxisY());
	}
	
	@Test(expected = ParseException.class)
	public void testParseFieldWithInvalidInputShouldThrowExceptionOnValidationFail() 
			throws ParseException {
		String fieldInput = "a 3";
		//TODO mock validator.. on validate return false
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		parser.parseField(fieldInput);
	}
	
	@Test
	public void testParseRover() throws ParseException {
		String inputRover = "1 2 N";
		
		//TODO mock field e fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
				
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		Rover rover = parser.parseRover(inputRover, field);
		
		assertNotNull(rover);
		assertEquals(1, rover.getPosition().getAxisX());
		assertEquals(2, rover.getPosition().getAxisY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test(expected = ParseException.class)
	public void testParseRoverWithInvalidInputShouldThrowExceptionOnValidationFail() 
			throws ParseException {
		String inputRover = "1 a N";
		
		//TODO mock field e fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
				
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		parser.parseRover(inputRover, field);
	}
	
	@Test
	public void testParseCommandList() throws ParseException {
		String inputCommand = "LRM";
		
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		List<Command> commandList = parser.parseCommandList(inputCommand);
		
		assertNotNull(commandList);
		assertEquals(3, commandList.size());
		assertEquals(Command.TURN_LEFT, commandList.get(0));
		assertEquals(Command.TURN_RIGHT, commandList.get(1));
		assertEquals(Command.MOVE, commandList.get(2));
	}
	
	@Test(expected = ParseException.class)
	public void testParseCommandListWithInvalidInputShouldThrowExceptionOnValidationFail() 
			throws ParseException {
		String inputCommand = "L RM";
		
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		parser.parseCommandList(inputCommand);
	}
	
}
