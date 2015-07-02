package br.com.elo7.mars.parser;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.validation.Validation;

public class Parser {
	
	private final InputValidator validator;

	public Parser(InputValidator validator) {
		this.validator = validator;
	}

	public Field parseField(String fieldInput) throws ParseException {
		Validation validation = validator.validateFieldInput(fieldInput);
		
		if(validation.isOk()) {
			int fieldLimitX = Character.getNumericValue(
					fieldInput.charAt(0));
			int fieldLimitY = Character.getNumericValue(
					fieldInput.charAt(2));
			
			Position fieldArea = new Position(fieldLimitX, fieldLimitY);
			Field field = new Field(fieldArea);
			return field;
		} else {
			throw new ParseException(validation.getMessage());
		}
	}

	public Rover parseRover(String inputRover, Field field) throws ParseException {
		Validation validation = validator.validateRoverInput(inputRover);
		
		if(validation.isOk()) {
			int axisX = Character.getNumericValue(inputRover.charAt(0));
			int axisY = Character.getNumericValue(inputRover.charAt(2));
			char directionChar = inputRover.charAt(4);
			
			Direction direction = Direction.valueOf(directionChar);
			Position position = new Position(axisX, axisY);
			Rover rover = new Rover(field, position, direction);
			return rover;
		} else {
			throw new ParseException(validation.getMessage());
		}
	}

}
