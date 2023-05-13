package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.unlam.dominio.MarcaDeTelefono;
import ar.edu.unlam.dominio.Producto;
import ar.edu.unlam.dominio.Telefono;
import ar.edu.unlam.dominio.Tienda;

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

}
