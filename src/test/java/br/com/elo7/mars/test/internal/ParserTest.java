package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.spec.Bidimensional;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.vo.RoverVO;

public class ParserTest {
	
	@Test
	public void testParsePosition() throws ParseException {
		String fieldInput = "5 3";
		
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		Bidimensional position = parser.parsePosition(fieldInput);
		
		assertNotNull(position);
		assertEquals(5, position.getAxisX());
		assertEquals(3, position.getAxisY());
	}
	
	@Test(expected = ParseException.class)
	public void testParseFieldWithInvalidInputShouldThrowExceptionOnValidationFail() 
			throws ParseException {
		String fieldInput = "a 3";
		//TODO mock validator.. on validate return false
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		parser.parsePosition(fieldInput);
	}
	
	@Test
	public void testParseRover() throws ParseException {
		String inputRover = "1 2 N";
				
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		RoverVO rover = parser.parseRover(inputRover);
		
		assertNotNull(rover);
		assertEquals(1, rover.getPosition().getAxisX());
		assertEquals(2, rover.getPosition().getAxisY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test(expected = ParseException.class)
	public void testParseRoverWithInvalidInputShouldThrowExceptionOnValidationFail() 
			throws ParseException {
		String inputRover = "1 a N";
				
		//TODO mock validator
		InputValidator validator = new InputValidator();
		Parser parser = new Parser(validator);
		
		parser.parseRover(inputRover);
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
