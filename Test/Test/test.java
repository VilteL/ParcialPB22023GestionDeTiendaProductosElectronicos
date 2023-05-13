package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.edu.unlam.dominio.*;

public class test {

	@Test
	public void QueSePuedaAgregarUnClienteALaTienda() throws clienteRepetidoException {
		Cliente cliente = new Cliente (30456729, "Pepe Argento");
		Tienda tienda = new Tienda ("Coppel");
		
		tienda.agregarCliente(cliente);
		
		assertEquals ((Integer)1,tienda.getCantidadDeClientesEnLaTienda());
	}
	
	@Test
	public void QueElClientePuedaAgregarUnProductoAlCarrito() {
		Cliente cliente = new Cliente (32134132, "Aquiles Bailo");
		Producto Telefono = new Telefono ("Galaxy S22", 154213.30, MarcaDeTelefono.SAMSUNG);
		
		cliente.agregarProductoAlCarrito(Telefono, true);
		
		assertEquals((Integer)1,cliente.getCantidadDeProductosEnElCarrito());
	}

	@Test
	public void QueSiNoSeEncuentraElClienteACobrarSeLanceLaExcepcion() {
		
	}

	@Test
	public void QueSePuedaEncontrarUnClienteBuscado() {
		
	}

	@Test
	public void QueSiElCarritoEstaVacioSeLanceLaExcepcion() {
		
	}

}
