package exceptions;

public class raceCodeUnabaliableException extends Exception{
	String message;

	public raceCodeUnabaliableException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
