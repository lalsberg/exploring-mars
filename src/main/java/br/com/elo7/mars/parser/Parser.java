package br.com.elo7.mars.parser;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.spec.Bidimensional;
import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.validation.Validation;
import br.com.elo7.mars.vo.RoverVO;

/**
 * Parses from user input to model classes.
 * Every user input is validated according to 
 * the expected result before parsing.
 *
 */
public class Parser {
	
	private final InputValidator validator;

	@Inject
	public Parser(InputValidator validator) {
		this.validator = validator;
	}

	public Bidimensional parsePosition(String positionInput) throws ParseException {
		Validation validation = validator.validatePositionInput(positionInput);
		
		if(validation.isOk()) {
			int fieldLimitX = Character.getNumericValue(
					positionInput.charAt(0));
			int fieldLimitY = Character.getNumericValue(
					positionInput.charAt(2));
			
			Bidimensional position = new Position(fieldLimitX, fieldLimitY);
			return position;
		} else {
			throw new ParseException(validation.getMessage());
		}
	}

	public RoverVO parseRover(String inputRover) throws ParseException {
		Validation validation = validator.validateRoverInput(inputRover);
		
		if(validation.isOk()) {
			int axisX = Character.getNumericValue(inputRover.charAt(0));
			int axisY = Character.getNumericValue(inputRover.charAt(2));
			char directionChar = inputRover.charAt(4);
			
			Direction direction = Direction.valueOf(directionChar);
			Bidimensional position = new Position(axisX, axisY);
			RoverVO rover = new RoverVO(position, direction);
			return rover;
		} else {
			throw new ParseException(validation.getMessage());
		}
	}

	public List<Command> parseCommandList(String inputCommand) 
			throws ParseException {
		Validation validation = validator.validateCommandInput(inputCommand);
		
		if(validation.isOk()) {
			List<Command> commandList = new ArrayList<Command>();
			char[] commandArray = inputCommand.toCharArray();
			for (char commandChar : commandArray) {
				Command command = Command.valueOf(commandChar);
				commandList.add(command);
			}
			return commandList;
		} else {
			throw new ParseException(validation.getMessage());
		}
	}

}
