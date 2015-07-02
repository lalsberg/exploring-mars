package br.com.elo7.mars.exception;

public class ParseException extends Exception {

	private static final long serialVersionUID = -6405859181573182765L;
	
	private final String message;
	
	public ParseException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "ParseException [message=" + message + "]";
	}

}