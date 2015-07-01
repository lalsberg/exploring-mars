package br.com.elo7.mars.model;

public final class Position {
	
	private final int axisX;
	private final int axisY;
	
	public Position(int axisX, int axisY) {
		this.axisX = axisX;
		this.axisY = axisY;
	}

	public int getAxisX() {
		return axisX;
	}

	public int getAxisY() {
		return axisY;
	}

}