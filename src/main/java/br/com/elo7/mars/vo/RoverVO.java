package br.com.elo7.mars.vo;

import br.com.elo7.mars.enumeration.Direction;
import br.com.elo7.mars.model.spec.Bidimensional;

public class RoverVO {

	private final Bidimensional position;
	private final Direction direction;

	public RoverVO(Bidimensional position, Direction direction) {
		this.position = position;
		this.direction = direction;
	}

	public Bidimensional getPosition() {
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
