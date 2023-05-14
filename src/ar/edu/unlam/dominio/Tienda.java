package ar.edu.unlam.dominio;

import java.util.*;

public class Tienda {
	
	private String nombre;
	private List <Cliente> clientes;
	private List <Producto> productos;
	
	public Tienda(String nombre) {
		this.nombre= nombre;
		this.clientes = new ArrayList<>();
		this.productos = new ArrayList<>();	
	}
	
	public void agregarCliente(Cliente cliente) throws ClienteRepetidoException {
		if(!this.clientes.contains(cliente))
			this.clientes.add(cliente);
		else
			throw new ClienteRepetidoException();
		
	}
	
	public Integer getCantidadDeClientesEnLaTienda() {
		return this.clientes.size();
	}
	
	public void agregarProducto(Producto producto) {
		this.productos.add(producto);
	}
	
	public void cobrarCliente(Cliente cliente) throws NoHayProductosEnElCarritoException, ClienteNoEncontradoException {
		ArrayList<Producto> productosComprados = cliente.getCarrito();
		
		if(this.clientes.contains(cliente)) {
			if(productosComprados.size()!=0){
				for (Producto producto : productosComprados) {
					
					cliente.agregarProductoYaCompradoALaListaDeProductosComprados(producto);
				}
				cliente.vaciarCarrito();
			}
			else throw new NoHayProductosEnElCarritoException();
		} else throw new ClienteNoEncontradoException();
	}
	
	public Cliente buscarClientePorNombre(Cliente clienteABuscar) throws ClienteNoEncontradoException {
		for (Cliente cliente : clientes) {
			if(cliente.equals(clienteABuscar)) {
				return cliente;
			}
		}
		throw new ClienteNoEncontradoException();
	}
	public Integer cantidadDeProductosEnLaTienda() {
		return this.productos.size();
	}
	

	public Cliente conseguirClienteConMayorCantidadDeProductosComprados() {
		Cliente clienteConMayorCantidadProductos  = this.clientes.stream()
				.max(Comparator.comparingInt(cliente -> cliente.getCantidadDeProductosEnElCarrito()))
				.orElse(null);
		
		return clienteConMayorCantidadProductos;
	}

	/*public Cliente getClienteConMayorCantidadDeProductosComprados() {
		Cliente clienteConLaMayorCantidadDeProductos = null;
		Integer mayorCantidadDeProductos = 0;
		for (Cliente cliente : clientes) {
			if (cliente.getCantidadDeProductosEnElCarrito() > mayorCantidadDeProductos) {
				clienteConLaMayorCantidadDeProductos = cliente;
				mayorCantidadDeProductos = cliente.getCantidadDeProductosEnElCarrito();
			}
		} return clienteConLaMayorCantidadDeProductos;
	} */
	
	public Cliente conseguirClienteQueHayaGastadoMas(){
		Cliente clienteQueGastoMas = this.clientes.stream()
				.max(Comparator.comparingDouble(c -> c.getCantidadDineroGastado()))
				.orElse(null);
		return clienteQueGastoMas;
	}
}
