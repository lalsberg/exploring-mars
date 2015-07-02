package br.com.elo7.mars.console;

import java.util.Scanner;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.validation.ConsoleValidator;
import br.com.elo7.mars.validation.Validation;

/**
 * This class is responsible for reading user's input 
 * from the console and parsing it to model classes 
 *
 */
public class Console {
	
	private final Scanner scanner;
	private final ConsoleValidator validator;

	public Console(Scanner scanner, ConsoleValidator validator) {
		this.scanner = scanner;
		this.validator = validator;
	}

	/**
	 * Process the user input, creating a Rover if the user 
	 * entered with Rover values or null if the user decided 
	 * to stop.
	 * @param field
	 * @return the Rover / null if the user stopped the input
	 * @throws IllegalArgumentException if the input is invalid
	 */
	public Rover obtainRoverOrStop(Field field) throws IllegalArgumentException{
		String inputRoverOrStop = scanner.nextLine().trim();
		Rover rover;
		if(userStopped(inputRoverOrStop)) {
			rover = null;
		} else {
			Validation validation = validator.
					validateRoverInput(inputRoverOrStop);
			
			if(validation.isOk()) {
				int axisX = Character.getNumericValue(
						inputRoverOrStop.charAt(0));
				int axisY = Character.getNumericValue(
						inputRoverOrStop.charAt(2));
				
				char directionChar = inputRoverOrStop.charAt(4);
				Direction direction = Direction.valueOf(directionChar);
				Position position = new Position(axisX, axisY);
				rover = new Rover(field, position, direction);
			} else {
				throw new IllegalArgumentException(validation.getMessage());
			}
		} 
		return rover;
	}

	public Field obtainField() {
		String fieldEndPosition = scanner.nextLine().trim();
		Validation validation = validator.
				validateFieldInput(fieldEndPosition);
		
		if(validation.isOk()) {
			int fieldLimitX = Character.getNumericValue(
					fieldEndPosition.charAt(0));
			int fieldLimitY = Character.getNumericValue(
					fieldEndPosition.charAt(2));
			Position fieldArea = new Position(fieldLimitX, fieldLimitY);
			Field field = new Field(fieldArea);
			return field;
		} else {
			throw new IllegalArgumentException(validation.getMessage());
		}
	}
	
	private boolean userStopped(String inputRoverOrStop) {
		return "s".equals(inputRoverOrStop);
	}
	
}