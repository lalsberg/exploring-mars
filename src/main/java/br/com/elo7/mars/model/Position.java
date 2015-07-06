package br.com.elo7.mars.model;

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