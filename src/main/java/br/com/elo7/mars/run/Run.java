package br.com.elo7.mars.run;

import java.util.List;
import java.util.Scanner;

import br.com.elo7.mars.enumeration.Command;
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
			boolean userStopped = false;
			do {
				String roverInput = scanner.nextLine().trim();
				userStopped = userStopped(roverInput);
				
				if(!userStopped) {
					Rover rover = parser.parseRover(roverInput, field);
					String commandInput = scanner.nextLine().trim();
					List<Command> commandList = parser.parseCommandList(commandInput);
					for (Command command : commandList) {
						rover.doCommand(command);
					}
				}
			} while(!userStopped);
			//TODO: for(Rover rover : field.getRovers()) { String roverOutput = Parser.parseString(rover); System.out.println(roverOutput);}
			
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
