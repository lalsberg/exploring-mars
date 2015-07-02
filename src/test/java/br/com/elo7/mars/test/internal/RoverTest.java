package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;

public class RoverTest {
	
	@Test
	public void testMoveNorth() {
		int fieldLimitX = 5;
		int fieldLimitY = 5;
		//TODO mock fieldArea
		Position fieldArea = new Position(fieldLimitX, fieldLimitY);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover rover = new Rover(field, roverPosition, direction);
		
		rover.move();
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY + 1, rover.getPosition().getAxisY());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidPosition() {
		int fieldLimitX = 5;
		int fieldLimitY = 5;
		//TODO mock fieldArea
		Position fieldArea = new Position(fieldLimitX, fieldLimitY);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 6;
		int roverAxisY = 2;
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		new Rover(field, roverPosition, direction);
	}
	
	//TODO testMoveAgainstWall
	//TODO testMoveAgainstRover

}