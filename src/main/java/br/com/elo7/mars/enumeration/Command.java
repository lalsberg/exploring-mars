package br.com.elo7.mars.enumeration;

import java.util.HashMap;
import java.util.Map;

public enum Command {
	MOVE('M'), 
	TURN_LEFT('L'), 
	TURN_RIGHT('R');
	
	private char inputCommand;
	private static Map<Character, Command> byInputCommand = 
			new HashMap<Character, Command>();
	
	static {
        for (Command Command : Command.values()) {
        	byInputCommand.put(Command.inputCommand, Command);
        }
	}

	private Command(char inputCommand) {
		this.inputCommand = inputCommand;
	}

	public char getInputCommand() {
		return inputCommand;
	}
	
	public static Command valueOf(Character inputCommand) {
        return byInputCommand.get(inputCommand);
    }
	
}
