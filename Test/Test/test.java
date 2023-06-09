package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import ar.edu.unlam.dominio.*;

public class test {

	@Test
	public void QueSePuedaAgregarUnClienteALaTienda() throws ClienteRepetidoException {
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

	@Test (expected = ClienteNoEncontradoException.class)
	public void QueSiNoSeEncuentraElClienteACobrarSeLanceLaExcepcion() throws ClienteRepetidoException, NoHayProductosEnElCarritoException, ClienteNoEncontradoException {
		Cliente cliente1 = new Cliente (34959942, "Esteban Quito");
		Cliente cliente2 = new Cliente (45433422, "Hen");
		Tienda tienda = new Tienda ("Coppel");
		
		tienda.agregarCliente(cliente1);
		tienda.cobrarCliente(cliente2);
	}

	@Test
	public void QueSePuedaEncontrarUnClienteBuscado() throws ClienteRepetidoException, ClienteNoEncontradoException {
		Cliente cliente1 = new Cliente (34959942, "Esteban Quito");
		Tienda tienda = new Tienda ("Coppel");
		
		tienda.agregarCliente(cliente1);
		
		Cliente clienteEsperado = cliente1;
		Cliente clienteBuscado = tienda.buscarClientePorNombre(cliente1);
		
		assertEquals(clienteEsperado, clienteBuscado);
	}

	@Test (expected = NoHayProductosEnElCarritoException.class)
	public void QueSiElCarritoEstaVacioCuandoSeCobreSeLanceLaExcepcion() throws NoHayProductosEnElCarritoException, ClienteNoEncontradoException {
		Cliente cliente1 = new Cliente (34959942, "Esteban Quito");
		Tienda tienda = new Tienda ("Coppel");
		
		try {
			tienda.agregarCliente(cliente1);
		} catch (ClienteRepetidoException e) {
			e.printStackTrace();
		}
		
		tienda.cobrarCliente(cliente1);
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
	
	@Test (expected = ClienteRepetidoException.class)
	public void queSiSeIntentaAgregarUnClienteRepetidoSeLanceExcepcion() throws ClienteRepetidoException {
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
		} catch (ClienteRepetidoException e) {
			e.printStackTrace();
		}
		
		cliente.agregarProductoAlCarrito(producto1,true);
		try {
			tienda.cobrarCliente(cliente);
		} catch (NoHayProductosEnElCarritoException | ClienteNoEncontradoException e) {
			e.printStackTrace();
		}
		Integer productosCompradosEsperados = 1;
		Integer productosComprados = cliente.getListaDeProductosComprados().size();
		
		Integer productosEsperadosEnElCarrito = 0;
		Integer productosEnElCarrito = cliente.getCarrito().size();
	
		
		assertEquals(productosCompradosEsperados, productosComprados);
		assertEquals(productosEsperadosEnElCarrito, productosEnElCarrito);
		
	}
	@Test (expected = ClienteNoEncontradoException.class)
	public void queNoSePuedaCobrarAUnClientesSiNoExisteEnLaTienda() throws NoHayProductosEnElCarritoException, ClienteNoEncontradoException {
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		
		Cliente cliente = new Cliente(111111, "pepito");
		
		cliente.agregarProductoAlCarrito(producto1,true);
		tienda.cobrarCliente(cliente);
	}
	@Test 
	public void queSeEncuentreAlClienteQueHayaCompradoMasProductos() {
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		Cliente cliente = new Cliente(111111, "pepito");
		
		Cliente cliente2 = new Cliente(99999, "Ricardo");
		
		try {
			tienda.agregarCliente(cliente);
			tienda.agregarCliente(cliente2);
		} catch (ClienteRepetidoException e) {
			e.printStackTrace();
		}
		cliente.agregarProductoAlCarrito(producto1,true);
		cliente.agregarProductoAlCarrito(producto1,true);
		cliente.agregarProductoAlCarrito(producto1,true);
		
		cliente2.agregarProductoAlCarrito(producto1,true);
		
		try {
			tienda.cobrarCliente(cliente);
			tienda.cobrarCliente(cliente2);
		} catch (NoHayProductosEnElCarritoException | ClienteNoEncontradoException e) {
			e.printStackTrace();
		}
		Cliente clienteEsperado = cliente;
		Cliente clienteDevuelto = tienda.conseguirClienteConMayorCantidadDeProductosComprados();
	
		assertEquals(clienteEsperado, clienteDevuelto);
	}
	@Test public void queSeEncuentreAlClienteQueHayaGastadoMas() {
		
		Tienda tienda = new Tienda("DIA");
		
		Producto producto1 = new Telefono("Galaxy s23", 450000.0, MarcaDeTelefono.SAMSUNG);
		tienda.agregarProducto(producto1);
		Cliente cliente = new Cliente(111111, "pepito");
		
		Cliente cliente2 = new Cliente(99999, "Ricardo");
		
		try {
			tienda.agregarCliente(cliente);
			tienda.agregarCliente(cliente2);
		} catch (ClienteRepetidoException e) {
			e.printStackTrace();
		}
		cliente.agregarProductoAlCarrito(producto1,true);
		cliente.agregarProductoAlCarrito(producto1,true);
		cliente.agregarProductoAlCarrito(producto1,true);
		
		cliente2.agregarProductoAlCarrito(producto1,true);
		
		try {
			tienda.cobrarCliente(cliente);
			tienda.cobrarCliente(cliente2);
		} catch (NoHayProductosEnElCarritoException | ClienteNoEncontradoException e) {
			e.printStackTrace();
		}
		Cliente clienteEsperado = cliente;
		Cliente clienteDevuelto = tienda.conseguirClienteQueHayaGastadoMas();
	
		assertEquals(clienteEsperado, clienteDevuelto);
	}
	
}
