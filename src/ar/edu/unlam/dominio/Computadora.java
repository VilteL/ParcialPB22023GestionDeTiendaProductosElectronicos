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
	public void calcularPrecioFinalVenta() {
		
		sumarCostoDeEnvio();
		
		if(this.marca.equals(MarcaDePC.BANGHO)) {
			this.setPrecio(getPrecio()*10/100);
		}
		else {
			this.setPrecio(getPrecio()*30/100);
		}
	}
	
}
