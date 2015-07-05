package br.com.elo7.mars.run;

import java.util.Scanner;

import br.com.elo7.mars.controlpanel.ControlPanel;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.task.ObtainRoversWithCommandsTask;
import br.com.elo7.mars.validation.InputValidator;

public class Application {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		try {
			InputValidator inputValidator = new InputValidator();
			Parser parser = new Parser(inputValidator);
			ObtainRoversWithCommandsTask obtainRoversTask = new 
					ObtainRoversWithCommandsTask(scanner, parser);
			ControlPanel panel = new ControlPanel(scanner, parser, 
					obtainRoversTask);
			
			panel.start();
		} finally {
			scanner.close();
		}
	}

}