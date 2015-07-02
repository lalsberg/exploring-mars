package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.Test;

import br.com.elo7.mars.console.Console;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.validation.ConsoleValidator;

public class ConsoleTest {
	
	@Test
	public void testObtainField() {
		String inputFieldEndPosition = "5 6";
		ByteArrayInputStream in = new ByteArrayInputStream(
				inputFieldEndPosition.getBytes());
		Scanner scanner = new Scanner(in);
		
		//TODO mock validator.
		ConsoleValidator validator = new ConsoleValidator();
		Console console = new Console(scanner, validator);
		Field field = console.obtainField();
		
		assertNotNull(field);
		assertEquals(5, field.getArea().getAxisX());
		assertEquals(6, field.getArea().getAxisY());
	}
	
	@Test
	public void testObtainRover() {
		String inputRover = "1 2 N";
		ByteArrayInputStream in = new ByteArrayInputStream(
				inputRover.getBytes());
		Scanner scanner = new Scanner(in);
		
		//TODO mock validator
		ConsoleValidator validator = new ConsoleValidator();
		Console console = new Console(scanner, validator);
		
		//TODO mock field e fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Rover rover = console.obtainRoverOrStop(field);
		
		assertNotNull(rover);
		assertEquals(1, rover.getPosition().getAxisX());
		assertEquals(2, rover.getPosition().getAxisY());
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test
	public void testObtainRoverWithStopCommandInput() {
		String inputRover = "s";
		ByteArrayInputStream in = new ByteArrayInputStream(
				inputRover.getBytes());
		Scanner scanner = new Scanner(in);
		
		//TODO mock validator
		ConsoleValidator validator = new ConsoleValidator();
		Console console = new Console(scanner, validator);
		
		//TODO mock field e fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Rover rover = console.obtainRoverOrStop(field);
		
		assertNull(rover);
	}
	
	//TODO testObtainRoverWithInvalidInputShouldReturnErrorMessage
	//TODO testObtainFieldWithInvalidInputShouldReturnErrorMessage

}