package br.com.elo7.mars.test.internal;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.com.elo7.mars.controlpanel.ControlPanel;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.Rover;

public class ControlPanelTest {
	
	@Test
	public void testControlPanelMustAlwaysBeInitializedWithField() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		ControlPanel controlPanel = new ControlPanel(field);
		
		assertEquals(field, controlPanel.getField());
	}
	
	@Test
	public void testLand() {
		Position fieldArea = new Position(5, 5);
		Field field = new Field(fieldArea);
		
		Position position = new Position(3, 3);
		Direction direction = Direction.NORTH;
		Rover rover = new Rover(field, position, direction);
		
		position = new Position(2, 2);
		direction = Direction.SOUTH;
		Rover rover2 = new Rover(field, position, direction);
		
		ControlPanel controlPanel = new ControlPanel(field);
		
		controlPanel.land(rover);
		controlPanel.land(rover2);
		
		assertEquals(field.getRovers().size(), 2);
		assertEquals(field.getRovers().get(0), rover);
		assertEquals(field.getRovers().get(1), rover2);
	}
	
}
