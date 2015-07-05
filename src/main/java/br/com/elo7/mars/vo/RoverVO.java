package br.com.elo7.mars.vo;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.Position;

public class RoverVO {

	private final Position position;
	private final Direction direction;

	public RoverVO(Position position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Position getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	@Override
	public String toString() {
		return "RoverVO [position=" + position + ", direction=" + direction
				+ "]";
	}
	
}
