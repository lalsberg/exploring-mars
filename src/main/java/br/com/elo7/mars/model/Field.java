package br.com.elo7.mars.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.elo7.mars.model.spec.Bidimensional;

/**
 * Represents the Field which Rovers land.
 *
 */
public class Field {

	private final Bidimensional area;
	private List<Rover> rovers = new ArrayList<Rover>();

	public Field(Bidimensional area) {
		this.area = area;
	}
	
	public void addRover(Rover rover) {
		rovers.add(rover);
	}
	
	/**
	 * Check if the given position is inside the 
	 * Field's area and if it's not occupied by 
	 * another rover
	 */
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