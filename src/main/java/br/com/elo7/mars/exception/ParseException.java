package br.com.elo7.mars.exception;

/**
 * Exception that can be thrown by the Parser.
 * Checked because the client needs to remember 
 * to catch it in order to show an appropriate 
 * message to the user.
 *
 */
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