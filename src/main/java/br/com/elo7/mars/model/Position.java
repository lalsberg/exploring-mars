package br.com.elo7.mars.model;

public final class Position {
	
	private final int axisX;
	private final int axisY;
	
	public Position(int axisX, int axisY) {
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