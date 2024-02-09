package wallapop.usuarios;

import wallapop.compraVenta.Producto;

public class Vendedor {
	
	private String nombre;
	private Producto enVenta[];
	private Producto vendidos[];
	
	public Vendedor(String nombre) {
		this.nombre = nombre;
		this.enVenta = new Producto[10];
		this.vendidos = new Producto[10];
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Producto[] getEnVenta() {
		return enVenta;
	}

	public void setEnVenta(Producto[] enVenta) {
		this.enVenta = enVenta;
	}

	public Producto[] getVendidos() {
		return vendidos;
	}

	public void setVendidos(Producto[] vendidos) {
		this.vendidos = vendidos;
	}

	//Métodos
	public void addProductEnVenta(Producto p) {
		for(int i=0; i < this.enVenta.length; i++) {
			if(i == this.enVenta.length-1 && this.enVenta[i] != null) {
				throw new IllegalArgumentException("No puedes añadir más productos en venta. ");
			}
			if(this.enVenta[i] == null) {
				this.enVenta[i] = p;
				break;
			}
		}
	}
	
	public void addProductVendidos(Producto p) {
		for(int i=0; i < this.vendidos.length; i++) {
			if(i == this.vendidos.length-1 && this.vendidos[i] != null) {
				throw new IllegalArgumentException("No puedes añadir más productos vendidos. ");
			}
			if(this.vendidos[i] == null) {
				this.vendidos[i] = p;
				break;
			}
		}
	}
	
	public void removeProductEnVenta(Producto p) {
		boolean encontrado = false;
		
		for(int i=0; i < this.enVenta.length; i++) {
			if(this.enVenta[i] != null &&
					this.enVenta[i].getCodigo() == p.getCodigo()) {
				this.enVenta[i] = null;
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			throw new IllegalArgumentException("El producto en venta no se encontraba en el array. ");
		}
		
	}
	
	public void removeProductVendidos(Producto p) {
		boolean encontrado = false;
		
		for(int i=0; i < this.vendidos.length; i++) {
			if(this.vendidos[i] != null &&
					this.vendidos[i].getCodigo() == p.getCodigo()) {
				this.vendidos[i] = null;
				encontrado = true;
			}
		}
		
		if(!encontrado) {
			throw new IllegalArgumentException("El producto en venta no se encontraba en el array. ");
		}
	}

}
