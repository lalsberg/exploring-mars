package br.com.elo7.mars.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Field {

	private final Position area;
	private final List<Rover> rovers = new ArrayList<Rover>();

	public Field(Position area) {
		this.area = area;
	}

	public boolean supports(Position position) {
		boolean axisXFits = this.area.getAxisX() >= position.getAxisX();
		boolean axisYFits = this.area.getAxisY() >= position.getAxisY();
		return axisXFits && axisYFits;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	public Position getArea() {
		return area;
	}
	
	@Override
	public String toString() {
		return "Field [area=" + area + "]";
	}

	public List<Rover> getRovers() {
		return Collections.unmodifiableList(rovers);
	}
	
}
