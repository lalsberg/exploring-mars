package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;

public class RoverTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateRoverOutOfFieldMustThrowException() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(false);
		
		int roverAxisX = 6;
		int roverAxisY = 2;
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover.land(field, roverPosition, direction);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLandRoverOverAnotherRoverMustThrowException() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover.land(field, position, Direction.NORTH);
		Rover.land(field, position, Direction.NORTH);
	}
	
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
	
	@Test
	public void testCommandMoveEast() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.EAST;
		Rover rover = Rover.land(field, roverPosition, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX + 1, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveWest() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.WEST;
		Rover rover = Rover.land(field, roverPosition, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX - 1, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveSouth() {
		//TODO mock fieldArea
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		//TODO mock roverPosition
		Position roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.SOUTH;
		Rover rover = Rover.land(field, roverPosition, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY - 1, rover.getPosition().getAxisY());
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
	public void testCommandMoveAgainstRover() {
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
	
	@Test 
	public void testCommandTurnLeftLookingNorth() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.NORTH);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test 
	public void testCommandTurnRightLookingNorth() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.NORTH);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingWest() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.WEST);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.SOUTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingWest() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.WEST);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingEast() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.EAST);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingEast() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.EAST);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.SOUTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingSouth() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.SOUTH);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingSouth() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Rover rover = Rover.land(field, position, Direction.SOUTH);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.WEST, rover.getDirection());
	}

}
