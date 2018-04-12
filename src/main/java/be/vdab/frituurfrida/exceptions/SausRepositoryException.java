package be.vdab.frituurfrida.exceptions;

public class SausRepositoryException extends RuntimeException {
	private final static long serialVersionUID = 1L;
	
	public SausRepositoryException(String message) {
		super(message);
	}
}