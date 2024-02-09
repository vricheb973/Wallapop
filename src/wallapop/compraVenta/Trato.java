package wallapop.compraVenta;

import wallapop.usuarios.Comprador;
import wallapop.usuarios.Vendedor;

public class Trato {
	
	private Comprador comprador;
	private Vendedor vendedor;
	private Producto producto;
	
	private boolean firmaComprador;
	private boolean firmaVendedor;
	
	public Trato(Comprador comprador, Vendedor vendedor, Producto producto) {
		this.comprador = comprador;
		this.vendedor = vendedor;
		this.producto = producto;
		this.firmaComprador = false;
		this.firmaVendedor = false;
	}

	public Comprador getComprador() {
		return comprador;
	}

	public void setComprador(Comprador comprador) {
		this.comprador = comprador;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	//Metodos
	public void validar(Comprador c) {
		if(!this.comprador.getNombre().equals(c.getNombre())) {
			throw new IllegalArgumentException("El comprador no es el indicado al crear el trato.");
		}
		if(this.firmaComprador) {
			throw new IllegalStateException("El trato ya estaba validado.");
		}
		this.firmaComprador = true;

		//validar que el vendedor ya ha firmado
		if(this.firmaVendedor && this.firmaComprador) {
			//validar que el comprador tiene dinero disponible
			if(this.comprador.getDineroDisponible() < this.producto.getPrecio()) {
				throw new ArithmeticException("El comprador no tiene dinero suficiente.");
			}
						
			//remove producto de productos en venta del vendedor
			this.vendedor.removeProductEnVenta(this.producto);
			//add producto a vendidos del vendedor
			this.vendedor.addProductVendidos(this.producto);
			//add producto a comprados del comprador
			this.comprador.addProducto(this.producto);
			//añadir ultimo producto vendido
			Producto.setUltimoVendido(this.producto);
		}
		
	}
	
	public void validar(Vendedor v) {
		if(!this.vendedor.getNombre().equals(v.getNombre())) {
			throw new IllegalArgumentException("El vendedor no es el indicado al crear el trato.");
		}
		if(this.firmaVendedor) {
			throw new IllegalStateException("El trato ya estaba validado.");
		}
		this.firmaVendedor = true;

		//validar que el comprador ya ha firmado
		if(this.firmaComprador && this.firmaVendedor) {
			//validar que el comprador tiene dinero disponible
			if(this.comprador.getDineroDisponible() < this.producto.getPrecio()) {
				throw new ArithmeticException("El comprador no tiene dinero suficiente. ");
			}
			//remove producto de productos en venta del vendedor
			this.vendedor.removeProductEnVenta(this.producto);
			//add producto a vendidos del vendedor
			this.vendedor.addProductVendidos(this.producto);
			//add producto a comprados del comprador
			this.comprador.addProducto(this.producto);
			//añadir ultimo producto vendido
			Producto.setUltimoVendido(this.producto);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
