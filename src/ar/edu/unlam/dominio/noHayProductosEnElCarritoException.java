package ar.edu.unlam.dominio;

public class noHayProductosEnElCarritoException extends Exception {
	
	public noHayProductosEnElCarritoException(String msj) {
		super(msj);
	}
	public noHayProductosEnElCarritoException() {}
}
