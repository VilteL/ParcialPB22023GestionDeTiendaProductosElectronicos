package ar.edu.unlam.dominio;

public class NoHayProductosEnElCarritoException extends Exception {
	
	public NoHayProductosEnElCarritoException(String msj) {
		super(msj);
	}
	public NoHayProductosEnElCarritoException() {}
}
