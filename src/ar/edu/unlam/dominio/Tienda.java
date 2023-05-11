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
	
	public void cobrarCliente(Cliente cliente) throws noHayProductosEnElCarritoException {
		ArrayList<Producto> productosComprados = cliente.getCarrito();
		
		if(this.clientes.contains(cliente)) {
			if(productosComprados!=null){
				for (Producto producto : productosComprados) {
					cliente.agregarProductoYaCompradoALaListaDeProductosComprados(producto);
				
				}
				cliente.vaciarCarrito();
			}
			else throw new noHayProductosEnElCarritoException();
		} //agregar excepcion en caso de que el cliente no este en el array de clientes.
	}
	
	public Cliente buscarClientePorNombre(Cliente clienteABuscar) throws clienteNoEncontradoException {
		for (Cliente cliente : clientes){
			if(cliente.equals(clienteABuscar)) {
				return cliente;
			}
		}
		throw new clienteNoEncontradoException();
	}
}
