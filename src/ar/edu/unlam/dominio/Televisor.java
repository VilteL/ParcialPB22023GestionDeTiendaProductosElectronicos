package ar.edu.unlam.dominio;

public class Televisor extends Producto {

	private MarcaDeTelevisor marca;
	
	public Televisor(String nombre, Double precio, MarcaDeTelevisor marca) {
		super(nombre, precio);
		this.marca = marca;
	}

	public MarcaDeTelevisor getMarca() {
		return marca;
	}

	@Override
	public void calcularPrecioFinalVenta() {
		sumarCostoDeEnvio();
		switch(marca) {
		
			case SAMSUNG:
				this.setPrecio(getPrecio()*50/100);
				break;
			case LG: 
				this.setPrecio(getPrecio()*50/100);
				break;
			case SONY:
				this.setPrecio(getPrecio()*50/100);
				break;
			case SANYO:
				this.setPrecio(getPrecio()*15/100);
				break;
			case HITACHI:
				this.setPrecio(getPrecio()*15/100);	
				break;
		}
	}
	
	

}
