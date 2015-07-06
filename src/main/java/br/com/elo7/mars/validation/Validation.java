package br.com.elo7.mars.validation;

/**
 * Represents a Validation result.
 * Validations which 'ok' is true may have no message.
 *
 */
public class Validation {

	private final boolean ok;
	private final String message;
	
	/**
	 * @param ok validation result
	 * @param message should always hold an useful message 
	 * to be printed to the user when validation fails.
	 */
	public Validation(boolean ok, String message) {
		super();
		this.ok = ok;
		this.message = message;
	}

	/**
	 * If the validation has no errors
	 */
	public boolean isOk() {
		return ok;
	}

	/**
	 * A message associated with the validation. 
	 */
	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Validation [ok=" + ok + ", message=" + message + "]";
	}
	
}