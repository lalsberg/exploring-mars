package br.com.elo7.mars.task;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.vo.RoverVO;

/**
 * Read Rovers and Commands from user's input.
 *
 */
public class ObtainRoversWithCommandsTask {

	private final Scanner scanner;
	private final Parser parser;

	public ObtainRoversWithCommandsTask(Scanner scanner, Parser parser) {
		this.scanner = scanner;
		this.parser = parser;
	}

	/**
	 * Read Rovers and Commands from user's input.
	 * A LinkedHashMap is used to keep the insertion 
	 * order.
	 * @return 
	 * @throws ParseException
	 */
	public LinkedHashMap<RoverVO, List<Command>> obtainRoversWithCommands() 
			throws ParseException {
		LinkedHashMap<RoverVO, List<Command>> roversWithCommands = 
				new LinkedHashMap<RoverVO, List<Command>>();
		
		boolean userStopped = false;
		do {
			String roverInput = scanner.nextLine();
			userStopped = userStopped(roverInput);
			
			if(!userStopped) {
				RoverVO roverVO = parser.parseRover(roverInput);
				String commandInput = scanner.nextLine();
				List<Command> commandList = parser.parseCommandList(commandInput);
				roversWithCommands.put(roverVO, commandList);
			}
		
		} while(!userStopped);
		return roversWithCommands;
	}
	
	private boolean userStopped(String roverInput) {
		return "s".equals(roverInput);
	}
	
}
