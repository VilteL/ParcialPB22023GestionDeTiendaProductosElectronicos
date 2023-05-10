package ar.edu.unlam.dominio;

import java.util.*;

public class Cliente {
	
	private String nombre, direccion;
	private ArrayList <Producto> listaDeProductosComprados, carrito;
	
	public Cliente(String nombre, String direccion) {
		this.nombre = nombre;
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public ArrayList<Producto> getListaDeProductosComprados() {
		return listaDeProductosComprados;
	}

	public void setListaDeProductosComprados(ArrayList<Producto> listaDeProductosComprados) {
		this.listaDeProductosComprados = listaDeProductosComprados;
	}

	public ArrayList<Producto> getCarrito() {
		return carrito;
	}

	public void setCarrito(ArrayList<Producto> carrito) {
		this.carrito = carrito;
	}
	
	public Boolean agregarProductoAlCarrito (Producto producto) {
		return carrito.add(producto);
	}
}
