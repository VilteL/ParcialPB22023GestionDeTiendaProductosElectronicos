package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.dominio.Cliente;
import ar.edu.unlam.dominio.MarcaDeTelefono;
import ar.edu.unlam.dominio.Producto;
import ar.edu.unlam.dominio.Telefono;
import ar.edu.unlam.dominio.Tienda;
import ar.edu.unlam.dominio.clienteNoEncontradoException;
import ar.edu.unlam.dominio.clienteRepetidoException;
import ar.edu.unlam.dominio.noHayProductosEnElCarritoException;

public class test {

	@Test
	public void queSePuedaAgregarUnProductoAlStockDeLaTienda() {
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		
		Integer valorEsperado = 1;
		Integer valorDevuelto = tienda.cantidadDeProductosEnLaTienda();
		
		assertEquals(valorEsperado, valorDevuelto);
	}
	@Test (expected = clienteRepetidoException.class)
	public void queSiSeIntentaAgregarUnClienteRepetidoSeLanceExcepcion() throws clienteRepetidoException {
		Tienda tienda = new Tienda("DIA");
		
		Cliente cliente = new Cliente(111111, "pepito");
		
		tienda.agregarCliente(cliente);
		tienda.agregarCliente(cliente);
	}
	
	@Test
	public void queSePuedaCobrarAUnCliente() {
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		
		Cliente cliente = new Cliente(111111, "pepito");
		try {
			tienda.agregarCliente(cliente);
		} catch (clienteRepetidoException e) {
			e.printStackTrace();
		}
		
		cliente.agregarProductoAlCarrito(producto1);
		try {
			tienda.cobrarCliente(cliente);
		} catch (noHayProductosEnElCarritoException | clienteNoEncontradoException e) {
			e.printStackTrace();
		}
		Integer productosCompradosEsperados = 1;
		Integer productosComprados = cliente.getListaDeProductosComprados().size();
		
		Integer productosEsperadosEnElCarrito = 0;
		Integer productosEnElCarrito = cliente.getCarrito().size();
	
		
		assertEquals(productosCompradosEsperados, productosComprados);
		assertEquals(productosEsperadosEnElCarrito, productosEnElCarrito);
		
	}
	

}
