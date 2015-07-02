package br.com.elo7.mars.run;

import java.util.Scanner;

import br.com.elo7.mars.console.Console;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.validation.ConsoleValidator;

public class Run {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ConsoleValidator consoleValidator = new ConsoleValidator();
		Console console = new Console(scanner, consoleValidator);
		Field field = console.obtainField();
		console.obtainRover();
	}

}
