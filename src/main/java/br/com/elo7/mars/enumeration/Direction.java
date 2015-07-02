package br.com.elo7.mars.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
	
	NORTH('N'),
	SOUTH('S'),
	EAST('E'),
	WEST('W');
	
	private char command;
	private static Map<Character, Direction> byCommand = new HashMap<Character, Direction>();
	
	//Eagerly initializing a helper map to avoid iterating through 
	//Direction values many times.
	static {
        for (Direction direction : Direction.values()) {
        	byCommand.put(direction.command, direction);
        }
	}

	private Direction(char value) {
		this.command = value;
	}

	public char getValue() {
		return command;
	}
	
	public static Direction valueOf(Character command) {
        return byCommand.get(command);
    }
	
}