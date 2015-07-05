package br.com.elo7.mars.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.elo7.mars.model.spec.Bidimensional;

//TODO Field should have a single instance in app scope
public class Field {

	private final Bidimensional area;
	private List<Rover> rovers = new ArrayList<Rover>();

	public Field(Bidimensional area) {
		this.area = area;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	public boolean checkAvailable(Bidimensional position) {
		return isInsideArea(position) && !containsRover(position);
	}
	
	private boolean isInsideArea(Bidimensional position) {
		boolean axisXFits = area.getAxisX() >= position.getAxisX();
		boolean axisYFits = area.getAxisY() >= position.getAxisY();
		return axisXFits && axisYFits;
	}
	
	private boolean containsRover(Bidimensional position) {
		boolean contains = false;
		
		for(Rover rover : rovers) {
			contains = rover.getPosition().getAxisX() == position.getAxisX() &&
					rover.getPosition().getAxisY() == position.getAxisY();
			if(contains) break;
		}
		return contains;
	}
	
	public Bidimensional getArea() {
		return area;
	}

	public List<Rover> getRovers() {
		return Collections.unmodifiableList(rovers);
	}

	@Override
	public String toString() {
		return "Field [area=" + area + ", rovers=" + rovers + "]";
	}

}