package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.model.spec.Bidimensional;

public class RoverTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateRoverOutOfFieldMustThrowException() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(false);
		
		int roverAxisX = 6;
		int roverAxisY = 2;
		Bidimensional roverPosition = new Position(roverAxisX, roverAxisY);
		Direction direction = Direction.NORTH;
		Rover.land(field, roverPosition, direction);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLandRoverOverAnotherRoverMustThrowException() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Bidimensional position = new Position(3, 3);
		Rover.land(field, position, Direction.NORTH);
		Rover.land(field, position, Direction.NORTH);
	}
	
	@Test
	public void testCommandMoveNorth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		Bidimensional position = mock(Bidimensional.class);
		when(position.getAxisX()).thenReturn(roverAxisX);
		when(position.getAxisY()).thenReturn(roverAxisY);
		Direction direction = Direction.NORTH;
		Rover rover = Rover.land(field, position, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY + 1, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveEast() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		Bidimensional position = mock(Bidimensional.class);
		when(position.getAxisX()).thenReturn(roverAxisX);
		when(position.getAxisY()).thenReturn(roverAxisY);
		Direction direction = Direction.EAST;
		Rover rover = Rover.land(field, position, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX + 1, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveWest() {
		//TODO mock fieldArea
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		Bidimensional position = mock(Bidimensional.class);
		when(position.getAxisX()).thenReturn(roverAxisX);
		when(position.getAxisY()).thenReturn(roverAxisY);
		Direction direction = Direction.WEST;
		Rover rover = Rover.land(field, position, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX - 1, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveSouth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		int roverAxisX = 1;
		int roverAxisY = 2;
		Bidimensional position = mock(Bidimensional.class);
		when(position.getAxisX()).thenReturn(roverAxisX);
		when(position.getAxisY()).thenReturn(roverAxisY);
		Direction direction = Direction.SOUTH;
		Rover rover = Rover.land(field, position, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY - 1, rover.getPosition().getAxisY());
	}
	
	@Test
	public void testCommandMoveAgainstWall() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int roverAxisX = 5;
		int roverAxisY = 5;
		Bidimensional position = mock(Bidimensional.class);
		when(position.getAxisX()).thenReturn(roverAxisX);
		when(position.getAxisY()).thenReturn(roverAxisY);
		
		Direction direction = Direction.NORTH;
		Rover rover = Rover.land(field, position, direction);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test 
	public void testCommandMoveAgainstRover() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		int anotherRoverAxisX = 3;
		int anotherRoverAxisY = 3;
		Bidimensional anotherRoverPosition = mock(Bidimensional.class);
		when(anotherRoverPosition.getAxisX()).thenReturn(anotherRoverAxisX);
		when(anotherRoverPosition.getAxisY()).thenReturn(anotherRoverAxisY);
		Rover.land(field, anotherRoverPosition, Direction.NORTH);
		
		int roverAxisX = 3;
		int roverAxisY = 2;
		Bidimensional roverPosition = mock(Bidimensional.class);
		when(roverPosition.getAxisX()).thenReturn(roverAxisX);
		when(roverPosition.getAxisY()).thenReturn(roverAxisY);
		Rover rover = Rover.land(field, roverPosition, Direction.NORTH);
		
		rover.doCommand(Command.MOVE);
		
		assertEquals(roverAxisX, rover.getPosition().getAxisX());
		assertEquals(roverAxisY, rover.getPosition().getAxisY());
	}
	
	@Test 
	public void testCommandTurnLeftLookingNorth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.NORTH);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.WEST, rover.getDirection());
	}
	
	@Test 
	public void testCommandTurnRightLookingNorth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.NORTH);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingWest() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.WEST);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.SOUTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingWest() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.WEST);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingEast() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.EAST);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.NORTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingEast() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.EAST);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.SOUTH, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnLeftLookingSouth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.SOUTH);
		
		rover.doCommand(Command.TURN_LEFT);
		
		assertEquals(Direction.EAST, rover.getDirection());
	}
	
	@Test
	public void testCommandTurnRightLookingSouth() {
		Field field = mock(Field.class);
		when(field.checkAvailable(any(Position.class))).thenReturn(true);
		
		Bidimensional position = mock(Bidimensional.class);
		Rover rover = Rover.land(field, position, Direction.SOUTH);
		
		rover.doCommand(Command.TURN_RIGHT);
		
		assertEquals(Direction.WEST, rover.getDirection());
	}

}
