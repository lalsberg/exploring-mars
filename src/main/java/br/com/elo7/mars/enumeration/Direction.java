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
	private static Map<Direction, Direction> leftMap = 
			new HashMap<Direction, Direction>();
	private static Map<Direction, Direction> rightMap = 
			new HashMap<Direction, Direction>();
	
	static {
        for (Direction direction : Direction.values()) {
        	byInputCommand.put(direction.inputCommand, direction);
        }
        
        leftMap.put(NORTH, WEST);
        leftMap.put(SOUTH, EAST);
        leftMap.put(EAST, NORTH);
        leftMap.put(WEST, SOUTH);
        
        rightMap.put(NORTH, EAST);
        rightMap.put(SOUTH, WEST);
        rightMap.put(EAST, SOUTH);
        rightMap.put(WEST, NORTH);
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
	
	public Direction left() {
        return leftMap.get(this);
    }
	
	public Direction right() {
        return rightMap.get(this);
    }
	
}
