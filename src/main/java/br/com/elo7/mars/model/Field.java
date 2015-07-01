package br.com.elo7.mars.model;

public class Field {

	private final Position area;

	public Field(Position area) {
		this.area = area;
	}

	public boolean supports(Position position) {
		boolean axisXFits = this.area.getAxisX() >= position.getAxisX();
		boolean axisYFits = this.area.getAxisY() >= position.getAxisY();
		return axisXFits && axisYFits;
		
	}
	
	public Position getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Field [area=" + area + "]";
	}

}