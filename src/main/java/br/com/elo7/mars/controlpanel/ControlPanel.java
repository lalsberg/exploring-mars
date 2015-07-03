package br.com.elo7.mars.controlpanel;

import br.com.elo7.mars.model.Field;
import br.com.elo7.mars.model.Rover;

public class ControlPanel {

	private final Field field;

	public ControlPanel(Field field) {
		this.field = field;
	}
	
	public void land(Rover rover) {
		field.addRover(rover);
	}
	
	public Field getField() {
		return field;
	}

	@Override
	public String toString() {
		return "ControlPanel [field=" + field + "]";
	}
	
}
