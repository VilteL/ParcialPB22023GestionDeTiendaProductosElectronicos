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

	@Test (expected = clienteNoEncontradoException.class)
	public void QueSiNoSeEncuentraElClienteACobrarSeLanceLaExcepcion() throws clienteRepetidoException, noHayProductosEnElCarritoException, clienteNoEncontradoException {
		Cliente cliente1 = new Cliente (34959942, "Esteban Quito");
		Cliente cliente2 = new Cliente (45433422, "Hen");
		Tienda tienda = new Tienda ("Coppel");
		
		tienda.agregarCliente(cliente1);
		tienda.cobrarCliente(cliente2);
	}

	@Test
	public void QueSePuedaEncontrarUnClienteBuscado() {
		
	}

	@Test
	public void QueSiElCarritoEstaVacioSeLanceLaExcepcion() {
	
	}

	@Test
	public void queSePuedaAgregarUnProductoAlStockDeLaTienda() {
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		
		Integer valorEsperado = 1;
		Integer valorDevuelto = tienda.cantidadDeProductosEnLaTienda();
		
		assertEquals(valorEsperado, valorDevuelto);
	}

}
