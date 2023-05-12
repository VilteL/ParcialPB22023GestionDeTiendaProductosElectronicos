package ar.edu.unlam.dominio;

public class Computadora extends Producto implements Vendible {
	
	private MarcaDePC marca;
	
	public Computadora(String nombre, Double precio, MarcaDePC marca) {
		super(nombre, precio);
		this.marca = marca;
	}
	
	public MarcaDePC getMarca() {
		return marca;
	}
	
	@Override
	public void calcularPrecioVenta() {
		if(this.marca.equals(MarcaDePC.BANGHO)) {
			super.setPrecio(getPrecio()*10/100);
		}
		else {
			super.setPrecio(getPrecio()*30/100);
		}
	}
	
}
