package ar.edu.unlam.dominio;

public class Televisor extends Producto implements Vendible {

	private MarcaDeTelevisor marca;
	
	public Televisor(String nombre, Double precio, MarcaDeTelevisor marca) {
		super(nombre, precio);
		this.marca = marca;
	}

	public MarcaDeTelevisor getMarca() {
		return marca;
	}

	@Override
	public void calcularPrecioVenta() {
		
	}
	
	

}
