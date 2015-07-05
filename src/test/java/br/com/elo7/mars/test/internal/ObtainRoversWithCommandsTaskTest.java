package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.task.ObtainRoversWithCommandsTask;
import br.com.elo7.mars.validation.InputValidator;
import br.com.elo7.mars.vo.RoverVO;

public class ObtainRoversWithCommandsTaskTest {
	
	@Test
	public void shouldReadRoversWhileNotReceivedStopCommand() 
			throws ParseException {
		
		ByteArrayInputStream in = twoRoversAndStopCommandInputStream();
		Scanner scanner = new Scanner(in);
		
		InputValidator inputValidator = new InputValidator();
		Parser parser = new Parser(inputValidator);
		
		ObtainRoversWithCommandsTask task = new 
				ObtainRoversWithCommandsTask(scanner, parser);
		LinkedHashMap<RoverVO, List<Command>> roversWithCommands = 
				task.obtainRoversWithCommands();
		
		assertEquals(2, roversWithCommands.size());
	}
	
	private ByteArrayInputStream twoRoversAndStopCommandInputStream() {
		String fieldLimitsPosition = "1 2 N\r\n"
				+ "LMLMLMLMM\r\n"
				+ "3 3 E\r\n"
				+ "MMRMMRMRRM\r\n"
				+ "s";
		ByteArrayInputStream in = new ByteArrayInputStream(
				fieldLimitsPosition.getBytes());
		return in;
	}
}
