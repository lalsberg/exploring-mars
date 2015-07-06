package br.com.elo7.mars.model.spec;

import br.com.elo7.mars.model.enumeration.Direction;

public interface Bidimensional {

	int getAxisX();
	int getAxisY();
	Bidimensional at(Direction direction);

}