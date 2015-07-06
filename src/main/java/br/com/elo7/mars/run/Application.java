package br.com.elo7.mars.run;

import java.util.Scanner;

import br.com.elo7.mars.model.ControlPanel;
import br.com.elo7.mars.util.WeldContext;

/**
 * Starts the application
 *
 */
public class Application {
	
	public static void main(String[] args) {
		final Scanner scanner = WeldContext.INSTANCE.getBean(Scanner.class);
		try {
			ControlPanel panel = WeldContext.INSTANCE.getBean(ControlPanel.class);
			panel.start();
		} finally {
			scanner.close();
		}
	}

}
