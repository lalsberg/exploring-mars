package br.com.elo7.mars.test.internal;

import static br.com.elo7.mars.model.enumeration.Direction.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.elo7.mars.model.Position;
import br.com.elo7.mars.model.spec.Bidimensional;

public class PositionTest {
	
	@Test
	public void atNorth() {
		int axisX = 1;
		int axisY = 2;
		Bidimensional position = new Position(axisX, axisY);
		Bidimensional positionAt = position.at(NORTH);
		
		assertEquals(axisX, positionAt.getAxisX());
		assertEquals(axisY + 1, positionAt.getAxisY());
	}
	
	@Test
	public void atEast() {
		int axisX = 1;
		int axisY = 2;
		Bidimensional position = new Position(axisX, axisY);
		Bidimensional positionAt = position.at(EAST);
		
		assertEquals(axisX + 1, positionAt.getAxisX());
		assertEquals(axisY, positionAt.getAxisY());
	}
	
	@Test
	public void atSouth() {
		int axisX = 1;
		int axisY = 2;
		Bidimensional position = new Position(axisX, axisY);
		Bidimensional positionAt = position.at(SOUTH);
		
		assertEquals(axisX, positionAt.getAxisX());
		assertEquals(axisY - 1, positionAt.getAxisY());
	}
	
	@Test
	public void atWest() {
		int axisX = 1;
		int axisY = 2;
		Bidimensional position = new Position(axisX, axisY);
		Bidimensional positionAt = position.at(WEST);
		
		assertEquals(axisX - 1, positionAt.getAxisX());
		assertEquals(axisY, positionAt.getAxisY());
	}

}
