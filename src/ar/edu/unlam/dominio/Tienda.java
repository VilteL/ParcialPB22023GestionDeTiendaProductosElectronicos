package ar.edu.unlam.dominio;

import java.util.*;

public class Tienda {
	
	
	private String nombre;
	private List<Cliente> clientes;
	private List<Producto> productos;
	
	public Tienda(String nombre) {
		this.nombre= nombre;
		
		this.clientes = new ArrayList<>();
		this.productos = new ArrayList<>();	
	}
	
	
	public void agregarCliente(Cliente cliente) {
		this.clientes.add(cliente);
	}
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void cobrarCliente(Cliente cliente) {
		ArrayList<Producto> productosComprados = cliente.getCarrito();
		
		for (Producto producto : productosComprados) {
			
		}
	}
	
}
