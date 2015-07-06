package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;
import br.com.elo7.mars.model.enumeration.Direction;
import br.com.elo7.mars.model.spec.Bidimensional;

public class FieldTest {
	
	@Test
	public void testCheckAvailable() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Bidimensional position = new Position(0, 0);
		Bidimensional position2 = new Position(3, 3);
		Bidimensional position3 = new Position(5, 5);

		assertTrue(field.checkAvailable(position));
		assertTrue(field.checkAvailable(position2));
		assertTrue(field.checkAvailable(position3));
	}
	
	@Test
	public void testCheckAvailableShouldReturnFalseWithPositionOutOfArea() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Bidimensional position = new Position(0, 6);
		Bidimensional position2 = new Position(6, 0);
		Bidimensional position3 = new Position(6, 6);

		assertFalse(field.checkAvailable(position));
		assertFalse(field.checkAvailable(position2));
		assertFalse(field.checkAvailable(position3));
	}
	
	@Test
	public void testCheckAvailableShouldReturnFalseWithPositionContainingRover() {
		Bidimensional fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Bidimensional roverPosition = new Position(3, 3);
		Rover.land(field, roverPosition, Direction.EAST);
		
		Bidimensional position = new Position(3, 3);

		assertFalse(field.checkAvailable(position));
	}
	
}
