package br.com.elo7.mars.validation;

/**
 * Validate if Strings are in the expected format.
 * All validation errors must provide an useful 
 * message.
 *
 */
public class InputValidator {
	
	public Validation validateFieldInput(String fieldInput) {
		String regex = "\\d\\s\\d";
		boolean matches = fieldInput.matches(regex);
		String message = matches ? "" : "Error: unexpected field end possition "
				+ "pattern. Example of valid input (remove quotes): \"1 3\"";
		Validation validation = new Validation(matches, message);
		return validation;
	}

	public Validation validateRoverInput(String roverInput) {
		String regex = "\\d\\s\\d\\s[NSWE]";
		boolean matches = roverInput.matches(regex);
		String message = matches ? "" : "Error: unexpected rover input pattern. "
				+ "Example of valid input (remove quotes): \"2 3 W\". For W you "
				+ "could use any of the following letters: N, S W, E";
		Validation validation = new Validation(matches, message);
		return validation;
	}

	public Validation validateCommandInput(String commandInput) {
		String regex = "[MRL]*";
		boolean matches = commandInput.matches(regex);
		String message = matches ? "" : "Error: unexpected command list input pattern. "
				+ "Example of valid input (remove quotes): \"MLRRLMMR\".";
		Validation validation = new Validation(matches, message);
		return validation;
	}

}