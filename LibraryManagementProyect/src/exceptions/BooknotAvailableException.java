package exceptions;

public class BooknotAvailableException extends Exception{
	
	public BooknotAvailableException() {
		
	}

	public BooknotAvailableException(String message) {
		super(message);
	}
}