package ar.edu.unlam.dominio;

public class Producto {
	
	private static Integer cantidadDeProductosCreados = 1;
	
	private Integer codProducto, impuesto;
	private String nombre;
	private Double precio, precioEnvio;
	private Boolean envio;

	public Producto(String nombre, Double precio) {
		this.nombre=nombre;
		this.precio = precio;
		this.codProducto = cantidadDeProductosCreados;	
		cantidadDeProductosCreados++;
	}
	
	public Integer getImpuesto() {
		return impuesto;
	}
	
	public void setImpuesto(Integer impuesto) {
		this.impuesto = impuesto;
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

	public Double getPrecioEnvio() {
		return precioEnvio;
	}

	public void setPrecioEnvio(Double precioEnvio) {
		this.precioEnvio = precioEnvio;
	}

	public Boolean getEnvio() {
		return envio;
	}

	public void setEnvio(Boolean envio) {
		this.envio = envio;
	}
	
	public void sumarCostoDeEnvio(Producto producto) {
		if (producto instanceof Televisor)
			this.precioEnvio=555.80;
		if (producto instanceof Telefono)
			this.precioEnvio=100.0;
		if (producto instanceof Computadora)
			this.precioEnvio=700.0;
	}
	
}
