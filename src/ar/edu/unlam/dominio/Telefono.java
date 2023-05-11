package ar.edu.unlam.dominio;

public class Telefono extends Producto implements Vendible {

	private MarcaDeTelefono marca;
	
	public Telefono(String nombre, Double precio, MarcaDeTelefono marca) {
		super(nombre, precio);
		this.marca = marca;
	}

	public MarcaDeTelefono getMarca() {
		return marca;
	}

	@Override
	public void calcularPrecioVenta() {
		
	}

}
