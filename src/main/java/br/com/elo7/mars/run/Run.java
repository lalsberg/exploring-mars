package br.com.elo7.mars.run;

import java.util.List;
import java.util.Scanner;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.vo.RoverVO;

public class Run {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String fieldAreaLimitsInput = scanner.nextLine().trim();
		InputValidator inputValidator = new InputValidator();
		
		try {
			Parser parser = new Parser(inputValidator);
			Position fieldArea = parser.parsePosition(fieldAreaLimitsInput);
			Field field = new Field(fieldArea);
			
			boolean userStopped = false;
			do {
				String roverInput = scanner.nextLine().trim();
				userStopped = userStopped(roverInput);
				
				if(!userStopped) {
					RoverVO roverVO = parser.parseRover(roverInput);
					Rover rover = Rover.land(field, roverVO.getPosition(), 
							roverVO.getDirection());
					String commandInput = scanner.nextLine().trim();
					List<Command> commandList = parser.parseCommandList(commandInput);
					for (Command command : commandList) {
						rover.doCommand(command);
					}
				}
			} while(!userStopped);
			System.out.println(field);
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
