package br.com.elo7.mars.validation;

public class Validation {

	private final boolean ok;
	private final String message;
	
	public Validation(boolean ok, String message) {
		super();
		this.ok = ok;
		this.message = message;
	}

	public boolean isOk() {
		return ok;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "Validation [ok=" + ok + ", message=" + message + "]";
	}
	
}