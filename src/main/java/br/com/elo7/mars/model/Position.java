package br.com.elo7.mars.model;

import br.com.elo7.mars.model.enumeration.Direction;
import br.com.elo7.mars.model.spec.Bidimensional;

/**
 * Represents a Bidimensional Position.
 *
 */
public final class Position implements Bidimensional {
	
	private final int axisX;
	private final int axisY;
	
	/**
	 * @param axisX
	 * @param axisY
	 * @throws IllegalArgumentException if axisX and/or 
	 * axisY is negative.
	 */
	public Position(int axisX, int axisY) throws IllegalArgumentException {
		if(axisX >= 0 && axisY >= 0) {
			this.axisX = axisX;
			this.axisY = axisY;
		} else {
			throw new IllegalArgumentException("axisX and axisY can "
					+ "not be less than 0. axisX: " + axisX + axisY + axisY);
		}
	}
	
	/**
	 * Return one position at the given direction. 
	 * @param direction
	 * @return
	 * @throws IllegalArgumentException if the direction 
	 * is neither NORTH, EAST, SOUTH or WEST. Also if 
	 * the returned position would have a negative axis.
	 */
	public Bidimensional at(Direction direction) throws IllegalArgumentException {
		Position position;
		switch (direction) {
			case NORTH:
				position = new Position(axisX, axisY + 1);
				break;
			case EAST:
				position = new Position(axisX + 1, axisY);
				break;
			case SOUTH:
				position = new Position(axisX, axisY - 1);
				break;
			case WEST:
				position = new Position(axisX - 1, axisY);
				break;
			default:
				throw new IllegalArgumentException("Position can't handle "
						+ "direction " + direction.name());
			}
		return position;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

	@Override
	public String toString() {
		return "Position [axisX=" + axisX + ", axisY=" + axisY + "]";
	}
	
}