package br.com.elo7.mars.model;

import br.com.elo7.mars.enumeration.Direction;

public class Rover {
	
	private Position position;
	private Direction direction;

	public Rover(Position position, Direction direction) {
		super();
		this.position = position;
		this.direction = direction;
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

}