package br.com.elo7.mars.model;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;

public class Rover {
	
	private Position position;
	private Direction direction;
	private Field field;
	
	//TODO redesign to observer pattern?
	public static Rover land(Field field, Position position, 
			Direction direction){
		//first call the private constructor
		Rover rover = new Rover(field, position, direction);
		//the object is now fully constructed, and can now be
		//passed safely to the outside world
		field.addRover(rover);
		return rover;
	}

	private Rover(Field field, Position position, Direction direction) {
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
		}
	}

	//TODO EAST, SOUTH, WEST by test
	private void move() {
		switch(direction) {
			case NORTH:
				Position nextPosition = new Position(position.getAxisX(), 
						position.getAxisY() + 1);
				if(field.checkAvailable(nextPosition)) {
					this.position = nextPosition;
				}
				break;
		case EAST:
			break;
		case SOUTH:
			break;
		case WEST:
			break;
		}
		
	}

	public Position getPosition() {
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