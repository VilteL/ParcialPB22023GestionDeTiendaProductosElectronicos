package ar.edu.unlam.dominio;

public class Venta {
	
	private Cliente cliente;
	private Producto producto;
	
	public Venta(Cliente cliente, Producto producto) {
		super();
		this.cliente = cliente;
		this.producto = producto;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public Producto getProducto() {
		return producto;
	}
	
}
