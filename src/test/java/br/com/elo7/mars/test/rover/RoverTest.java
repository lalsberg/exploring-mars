package br.com.elo7.mars.test.rover;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;

public class RoverTest {
	
	@Test
	public void testMoveNorth() {
		int roverAxisX = 1;
		int roverAxisY = 2;
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover rover = new Rover(roverPosition, direction);
		
		rover.move();
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY + 1, rover.getPosition().getAxisY());
	}
	
	//TODO testMoveAgainstWall
	//TODO testMoveAgainstRover

}