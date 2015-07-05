package br.com.elo7.mars.model;

import br.com.elo7.mars.enumeration.Command;
import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.spec.Bidimensional;

public class Rover {
	
	private Bidimensional position;
	private Direction direction;
	private Field field;
	
	//TODO redesign to observer pattern?
	public static Rover land(Field field, Bidimensional position, 
			Direction direction){
		Rover rover = new Rover(field, position, direction);
		field.addRover(rover);
		return rover;
	}

	private Rover(Field field, Bidimensional position, Direction direction) {
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

	private void move() {
		try {
			Bidimensional nextPosition = predictNextPosition();
			if(field.checkAvailable(nextPosition)) {
				this.position = nextPosition;
			}
			
		//An IllegalArgumentException here means that the rover 
		//tried to move outside the field. We do nothing.
		} catch(IllegalArgumentException e) { }
	}

	private Bidimensional predictNextPosition() throws IllegalArgumentException {
		Bidimensional nextPosition;
		
		switch(direction) {
			case NORTH:
				nextPosition = new Position(position.getAxisX(), 
					position.getAxisY() + 1);
				break;
			case EAST:
				nextPosition = new Position(position.getAxisX() + 1, 
						position.getAxisY());
				break;
			case SOUTH:
				nextPosition = new Position(position.getAxisX(), 
						position.getAxisY() - 1);
				break;
			case WEST:
				nextPosition = new Position(position.getAxisX() - 1, 
						position.getAxisY());
				break;
			default:
				nextPosition = null;
				break;
		}
		return nextPosition;
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