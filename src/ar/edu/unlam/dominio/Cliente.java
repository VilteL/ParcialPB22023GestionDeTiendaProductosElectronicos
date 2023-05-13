package ar.edu.unlam.dominio;

import java.util.*;

public class Cliente {
	
	private Integer DNI;
	private String nombre;
	private ArrayList <Producto> listaDeProductosComprados, carrito;
	
	public Cliente (Integer DNI, String nombre) {
		this.DNI = DNI;
		this.nombre = nombre;
		this.listaDeProductosComprados = new ArrayList<>();
		this.carrito = new ArrayList<>();
	}
	
	public Integer getDNI() {
		return DNI;
	}

	public void setDNI(Integer dNI) {
		DNI = dNI;
	}
	
	// Getters and Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList <Producto> getListaDeProductosComprados() {
		return listaDeProductosComprados;
	}

	public void setListaDeProductosComprados(ArrayList<Producto> listaDeProductosComprados) {
		this.listaDeProductosComprados = listaDeProductosComprados;
	}

	public ArrayList<Producto> getCarrito() {
		return carrito;
	}

	//Nuestros metodos.
	public Boolean agregarProductoAlCarrito (Producto producto, Boolean seEnvia) {
		producto.setEnvio(seEnvia);
		if (producto instanceof Televisor) {
			((Televisor)producto).calcularPrecioFinalVenta();
		}
		if (producto instanceof Telefono) {
			((Telefono)producto).calcularPrecioFinalVenta();
		}
		if (producto instanceof Computadora) {
			((Computadora)producto).calcularPrecioFinalVenta();
		}
		return carrito.add(producto);
	}
	
	public void vaciarCarrito() {
		this.carrito.clear();
	}
	
	public void agregarProductoYaCompradoALaListaDeProductosComprados(Producto producto) {
		this.listaDeProductosComprados.add(producto);
	}
	
	public Integer getCantidadDeProductosEnElCarrito() {
		return this.carrito.size();
	}

}
