package br.com.elo7.mars.model;

import br.com.elo7.mars.model.enumeration.Command;
import br.com.elo7.mars.model.enumeration.Direction;
import br.com.elo7.mars.model.spec.Bidimensional;

/**
 * Represents a Rover in a Field.
 *
 */
public class Rover {
	
	private Bidimensional position;
	private Direction direction;
	private Field field;
	
	/**
	 * Create a Rover using the given parameters 
	 * and add it to the given Field.
	 * 
	 * @param field
	 * @param position
	 * @param direction
	 * @return
	 * @throws IllegalArgumentException if the given position has 
	 * a negative axis or is out of the field area.
	 * 
	 */
	public static Rover land(Field field, Bidimensional position, 
			Direction direction) throws IllegalArgumentException {
		Rover rover = new Rover(field, position, direction);
		field.addRover(rover);
		return rover;
	}

	private Rover(Field field, Bidimensional position, Direction direction) 
			throws IllegalArgumentException {
		if(field.checkAvailable(position)) {
			this.field = field;
			this.position = position;
			this.direction = direction;
		} else {
			throw new IllegalArgumentException("Rover position is "
					+ "out of the field area. Rover position: " + 
					position + ". Field area:" + field.getArea());
		}
	}
	
	public void doCommand(Command command) {
		switch(command) {
			case MOVE: 
				move();
				break;
		case TURN_LEFT:
			direction = direction.left();
			break;
		case TURN_RIGHT:
			direction = direction.right();
			break;
		}
	}

	/**
	 * Move to this Rover's direction. 
	 * Rover won't move if the next Field position 
	 * is unavailable.
	 */
	private void move() {
		try {
			Bidimensional nextPosition = position.at(direction);
			if(field.checkAvailable(nextPosition)) {
				this.position = nextPosition;
			}
			
		//An IllegalArgumentException here means that the rover 
		//tried to move outside the field. We do nothing.
		} catch(IllegalArgumentException e) { }
	}

	public Bidimensional getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "Rover [position=" + position + ", direction=" + direction + "]";
	}

}