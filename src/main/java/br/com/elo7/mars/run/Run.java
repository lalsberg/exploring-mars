package br.com.elo7.mars.run;

import java.util.Scanner;

import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.validation.InputValidator;

public class Run {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fieldInput = scanner.nextLine().trim();
		InputValidator inputValidator = new InputValidator();
		
		try {
			Parser parser = new Parser(inputValidator);
			Field field = parser.parseField(fieldInput);
			
			String roverInput = scanner.nextLine().trim();
			if(userStopped(roverInput)) {
				//TODO start process
			}
			Rover rover = parser.parseRover(roverInput, field);
		} catch(ParseException e) {
			System.out.println(e.getMessage());
		} finally {
			scanner.close();
		}
	}

	private static boolean userStopped(String roverInput) {
		return "s".equals(roverInput);
	}

}
