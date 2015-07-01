package br.com.elo7.mars.model;

import br.com.elo7.mars.enumeration.Direction;

public class Rover {
	
	private Position position;
	private Direction direction;

	public Rover(Field field, Position position, 
			Direction direction) {
		if(field.supports(position)) {
			this.position = position;
			this.direction = direction;
		} else {
			throw new IllegalArgumentException("Rover position is "
					+ "out of the field area. Rover position: " + 
					position + ". Field area:" + field.getArea());
		}
	}

	public void move() {
		switch(direction) {
			case NORTH:
				this.position = new Position(position.getAxisX(), 
						position.getAxisY() + 1);
				break;
		}
		
	}

	public Position getPosition() {
		return position;
	}

	@Override
	public String toString() {
		return "Rover [position=" + position + ", direction=" + direction + "]";
	}

}