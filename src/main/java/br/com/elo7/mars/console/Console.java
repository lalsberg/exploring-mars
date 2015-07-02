package br.com.elo7.mars.console;

import java.util.Scanner;

import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.validation.ConsoleValidator;
import br.com.elo7.mars.validation.Validation;

public class Console {
	
	private final Scanner scanner;
	private final ConsoleValidator validator;

	public Console(Scanner scanner, ConsoleValidator validator) {
		this.scanner = scanner;
		this.validator = validator;
	}

	public Rover obtainRover() {
		return null;
	}

	private boolean stop(String command) {
		return command.equals("s");
	}

	public Field obtainField() {
		String fieldEndPosition = scanner.nextLine().trim();
		Validation validation = validator.
				validateFieldEndPosition(fieldEndPosition);
		
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
	
	
	
}
