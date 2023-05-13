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
	public void calcularPrecioFinalVenta() {
		
		sumarCostoDeEnvio();
		switch (marca){
		case LG:
			this.setPrecio(getPrecio()*30/100);
			break;
		case SAMSUNG:
			this.setPrecio(getPrecio()*50/100);
			break;
		case MOTOROLA:
			this.setPrecio(getPrecio()*20/100);
			break;
		case IPHONE:
			this.setPrecio(getPrecio()*75/100);
			break;
		case XIAOMI:
			this.setPrecio(getPrecio()*40/100);
			break;
		case NOKIA:
			this.setPrecio(getPrecio()*15/100);
			break;
		}
	}

}
