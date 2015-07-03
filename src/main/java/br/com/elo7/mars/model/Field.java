package br.com.elo7.mars.model;

import java.util.ArrayList;
import java.util.List;

//TODO Field should have a single instance in app scope
public class Field {

	private final Position area;
	private List<Rover> rovers = new ArrayList<Rover>();

	public Field(Position area) {
		this.area = area;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	public boolean checkAvailable(Position position) {
		return isInsideArea(position) && !containsRover(position);
	}
	
	private boolean isInsideArea(Position position) {
		boolean axisXFits = area.getAxisX() >= position.getAxisX();
		boolean axisYFits = area.getAxisY() >= position.getAxisY();
		return axisXFits && axisYFits;
	}
	
	private boolean containsRover(Position position) {
		boolean contains = false;
		
		for(Rover rover : rovers) {
			contains = rover.getPosition().getAxisX() == position.getAxisX() &&
					rover.getPosition().getAxisY() == position.getAxisY();
			if(contains) break;
		}
		return contains;
	}
	
	public Position getArea() {
		return area;
	}

	@Override
	public String toString() {
		return "Field [area=" + area + ", rovers=" + rovers + "]";
	}

}