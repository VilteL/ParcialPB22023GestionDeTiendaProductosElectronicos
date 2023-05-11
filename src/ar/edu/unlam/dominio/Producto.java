package ar.edu.unlam.dominio;

public class Producto {
	private static Integer cantidadDeProductosCreados = 1;
	
	private Integer codProducto;
	private String nombre;
	private Double precio;
	private Integer impuesto;
	
	public Integer getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Integer impuesto) {
		this.impuesto = impuesto;
	}

	public Producto(String nombre, Double precio) {
		this.nombre=nombre;
		this.precio = precio;
		this.codProducto = cantidadDeProductosCreados;
		
		cantidadDeProductosCreados++;
	}
	
	public Integer getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Integer codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
}
