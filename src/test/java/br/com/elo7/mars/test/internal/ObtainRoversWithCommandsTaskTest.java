package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import br.com.elo7.mars.exception.ParseException;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.enumeration.Command;
import br.com.elo7.mars.model.enumeration.Direction;
import br.com.elo7.mars.parser.Parser;
import br.com.elo7.mars.task.ObtainRoversWithCommandsTask;
import br.com.elo7.mars.vo.RoverVO;

public class ObtainRoversWithCommandsTaskTest {
	
	@Test
	public void shouldReadRoversWhileNotReceivedStopCommand() 
			throws ParseException {
		
		ByteArrayInputStream in = twoRoversAndStopCommandInputStream();
		Scanner scanner = new Scanner(in);
		
		Parser parser = mock(Parser.class);
		when(parser.parseRover(anyString()))
				.thenAnswer(new Answer<RoverVO>() {
			public RoverVO answer(InvocationOnMock invocation) {
		        return new RoverVO(new Position(3, 3), Direction.NORTH);
		     }
		});
		
		ObtainRoversWithCommandsTask task = new 
				ObtainRoversWithCommandsTask(scanner, parser);
		LinkedHashMap<RoverVO, List<Command>> roversWithCommands = 
				task.obtainRoversWithCommands();
		
		assertEquals(2, roversWithCommands.size());
	}
	
	private ByteArrayInputStream twoRoversAndStopCommandInputStream() {
		String input = "1 2 N\r\n"
				+ "LMLMLMLMM\r\n"
				+ "3 3 E\r\n"
				+ "MMRMMRMRRM\r\n"
				+ "s\r\n";
		ByteArrayInputStream in = new ByteArrayInputStream(
				input.getBytes());
		return in;
	}
	
}
