package br.com.elo7.mars.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * Every Rover direction. This inputCommand value 
 * refers to the user's input. Each direction knows 
 * his left and right direction, retured by the 
 * methods left() and right().
 *
 */
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

	/**
	 * Refers to the user's input.
	 */
	public char getInputCommand() {
		return inputCommand;
	}
	
	/**
	 * Returns the command associated with the 
	 * given input command.
	 */
	public static Direction valueOf(Character inputCommand) {
        return byInputCommand.get(inputCommand);
    }
	
	
	/**
	 * Returns its left direction
	 * 
	 */
	public Direction left() {
        return leftMap.get(this);
    }
	
	/**
	 * Returns its right direction
	 * 
	 */
	public Direction right() {
        return rightMap.get(this);
    }
	
}
