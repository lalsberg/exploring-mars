package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;

public class RoverTest {
	
	@Test
	public void testCommandMoveNorth() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover rover = Rover.land(field, roverPosition, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY + 1, rover.getPosition().getAxisY());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateRoverOutOfField() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 6;
		int roverAxisY = 2;
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover.land(field, roverPosition, direction);
	}
	
	@Test
	public void testCommandMoveAgainstWall() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 5;
		int roverAxisY = 5;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover rover = Rover.land(field, roverPosition, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test 
	public void testMoveAgainstRover() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position anotherRoverPosition = new Position(3, 3);
		Rover.land(field, anotherRoverPosition, Direction.NORTH);
		
		//TODO mock roverPosition
		int roverAxisX = 3;
		int roverAxisY = 2;
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Rover rover = Rover.land(field, roverPosition, Direction.NORTH);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	//TODO testCommandMoveEast
	//TODO testCommandMoveWest
	//TODO testCommandMoveSouth

}