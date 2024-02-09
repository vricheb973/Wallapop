package wallapop.usuarios;

import wallapop.compraVenta.Producto;

public class Comprador {
	
	private String nombre;
	private Producto comprados[];
	private double dineroDisponible;
	
	public Comprador(String nombre) {
		this.nombre = nombre;
		this.comprados = new Producto[10];
		this.dineroDisponible = 0.0;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public Producto[] getComprados() {
		return comprados;
	}



	public void setComprados(Producto[] comprados) {
		this.comprados = comprados;
	}



	public double getDineroDisponible() {
		return dineroDisponible;
	}



	public void setDineroDisponible(double dineroDisponible) {
		this.dineroDisponible = dineroDisponible;
	}



	//Métodos
	public void addProducto(Producto p) {
		for(int i=0; i < this.comprados.length; i++) {
			if(i == this.comprados.length-1 && this.comprados[i] != null) {
				throw new IllegalArgumentException("No puedes añadir más productos. ");
			}
			if(this.comprados[i] == null) {
				this.comprados[i] = p;
				break;
			}
		}
	}
	
	public void removeProducto(Producto p) {
		boolean encontrado = false;
		
		for(int i=0; i < this.comprados.length; i++) {
			if(this.comprados[i] != null &&
					this.comprados[i].getCodigo() == p.getCodigo()) {
				this.comprados[i] = null;
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			throw new IllegalArgumentException("El producto en venta no se encontraba en el array. ");
		}
	}
	
	public void recargarDinero(double cantidad) {
		if(cantidad <= 0.0) {
			throw new IllegalArgumentException("La cantidad debe ser mayor que 0.0. ");
		}
		this.dineroDisponible += cantidad;
	}

}
