package br.com.elo7.mars.controlpanel;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.model.spec.Bidimensional;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.task.ObtainRoversWithCommandsTask;
import br.com.elo7.mars.vo.RoverVO;

public class ControlPanel {

	private final Scanner scanner;
	private final Parser parser;
	private ObtainRoversWithCommandsTask obtainRoversTask;

	public ControlPanel(Scanner scanner, Parser parser, 
			ObtainRoversWithCommandsTask obtainRoversTask) {
		this.scanner = scanner;
		this.parser = parser;
		this.obtainRoversTask = obtainRoversTask;

	}

	public void start() {
		try {
			Field field = initField();
			LinkedHashMap<RoverVO, List<Command>> roversWithCommands = 
					obtainRoversTask.obtainRoversWithCommands();
			landAndDoCommands(field, roversWithCommands);
			printRovers(field);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		
	}

	private void printRovers(Field field) {
		StringBuilder sb = new StringBuilder();
		for(Rover rover : field.getRovers()) {
			sb.append(rover.getPosition().getAxisX())
			.append(" ")
			.append(rover.getPosition().getAxisY())
			.append(" ")
			.append(rover.getDirection().getInputCommand())
			.append("\n");
		}
		System.out.println(sb.toString());
	}

	private void landAndDoCommands(Field field,
			LinkedHashMap<RoverVO, List<Command>> roversWithCommands) {
		Iterator<Map.Entry<RoverVO, List<Command>>> it = 
				roversWithCommands.entrySet().iterator();
		while (it.hasNext()) {
		    Map.Entry<RoverVO, List<Command>> pair = 
		    		(Map.Entry<RoverVO, List<Command>>) it.next();
		    RoverVO roverVO = pair.getKey();
		    List<Command> commandList = pair.getValue();
		    
		    Rover rover = Rover.land(field, roverVO.getPosition(), 
					roverVO.getDirection());
		    
		    doCommands(rover, commandList);
		}
	}

	private Field initField() throws ParseException {
		String fieldAreaLimitsInput = scanner.nextLine();
		
		Bidimensional fieldArea = parser.parsePosition(fieldAreaLimitsInput);
		Field field = new Field(fieldArea);
		return field;
	}

	private void doCommands(Rover rover, List<Command> commandList) {
		for (Command command : commandList) {
			rover.doCommand(command);
		}
	}

}