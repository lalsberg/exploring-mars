package br.com.elo7.mars.validation;

public class ConsoleValidator {
	
	public Validation validateFieldEndPosition(String fieldEndPosition) {
		String regex = "\\d\\s\\d";
		boolean matches = fieldEndPosition.matches(regex);
		String message = matches ? "" : "Error: unexpected field end possition "
				+ "pattern.";
		Validation validation = new Validation(matches, message);
		return validation;
	}

}
