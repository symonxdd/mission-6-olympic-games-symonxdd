package be.pxl.paj.olympicgames.api;

public class ErrorMessage {

	private final String message;

	public ErrorMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
