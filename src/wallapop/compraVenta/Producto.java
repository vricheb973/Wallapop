package wallapop.compraVenta;

import wallapop.compraVenta.enumerados.EstadoProducto;

public class Producto {
	
	private int codigo;
	private String nombre;
	private double precio;
	private EstadoProducto estado;
	
	private static int contadorCod;
	
	private static Producto masCaro;
	private static Producto masBarato;
	private static Producto ultimoVendido;
	
	public Producto(String nombre, double precio) {
		this.codigo = contadorCod+1;
		this.nombre = nombre;
		this.precio = precio;
		this.estado = EstadoProducto.NUEVO;
		contadorCod++;
		
		actualizaEstadisticas();
	}
	
	public Producto(String nombre, double precio, String estado) {
		this.codigo = contadorCod+1;
		this.nombre = nombre;
		this.precio = precio;
		this.estado = EstadoProducto.valueOf(estado);
		contadorCod++;
		
		actualizaEstadisticas();
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public static int getContadorCod() {
		return Producto.contadorCod;
	}

	public static void setContadorCod(int contadorCod) {
		Producto.contadorCod = contadorCod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public EstadoProducto getEstado() {
		return estado;
	}

	public void setEstado(EstadoProducto estado) {
		this.estado = estado;
	}
	
	public static Producto getMasCaro() {
		return masCaro;
	}
	
	public static Producto getMasBarato() {
		return masBarato;
	}

	public static Producto getUltimoVendido() {
		return ultimoVendido;
	}

	public static void setUltimoVendido(Producto ultimoVendido) {
		Producto.ultimoVendido = ultimoVendido;
	}

	private void actualizaEstadisticas() {
		if(masCaro == null && masBarato == null) {
			masCaro = this;
			masBarato = this;
		}
		if(this.precio > masCaro.getPrecio()) {
			masCaro = this;
		}
		if(this.precio < masBarato.getPrecio()) {
			masBarato = this;
		}
 	}
	
}
