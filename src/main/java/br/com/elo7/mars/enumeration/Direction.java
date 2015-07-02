package br.com.elo7.mars.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
	
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');
	
	private char inputCommand;
	private static Map<Character, Direction> byInputCommand = 
			new HashMap<Character, Direction>();
	
	//Eagerly initializing a helper map to avoid iterating through 
	//Direction values many times.
	static {
        for (Direction direction : Direction.values()) {
        	byInputCommand.put(direction.inputCommand, direction);
        }
	}

	private Direction(char inputCommand) {
		this.inputCommand = inputCommand;
	}

	public char getInputCommand() {
		return inputCommand;
	}
	
	public static Direction valueOf(Character inputCommand) {
        return byInputCommand.get(inputCommand);
    }
	
}
