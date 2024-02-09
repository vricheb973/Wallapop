package wallapop;

import wallapop.compraVenta.Producto;
import wallapop.compraVenta.Trato;
import wallapop.usuarios.Comprador;
import wallapop.usuarios.Vendedor;

public class Main {
	
	public static void main(String[] args) {
		
		//https://pastebin.com/kpxkW4aF
		
		//Creo productos
		Producto p1 = new Producto("leche", 1.0);
		Producto p2 = new Producto("papas fritas", 2.0);
		Producto p3 = new Producto("cerveza", 0.50);
		Producto p4 = new Producto("tomates", 1.50);
		Producto p5 = new Producto("alioli", 2.0);
		Producto p6 = new Producto("caviar", 200.0);
		Producto p7 = new Producto("chicle", 0.10);
		Producto p8 = new Producto("queso", 6.20);
		Producto p9 = new Producto("espetec", 2.10);
		Producto p10 = new Producto("coca cola", 0.53);
		Producto p11 = new Producto("caña lomo", 2.36);
		
		//Creo comprador y vendedor
		Comprador c1 = new Comprador("vladi");
		Vendedor v1 = new Vendedor("Pablo");
		

		Comprador c2 = new Comprador("adri");
		Vendedor v2 = new Vendedor("Ángela");
		
		//Añado productos
		c1.addProducto(p1);
		c1.addProducto(p2);
		c1.addProducto(p3);
		c1.addProducto(p4);
		c1.addProducto(p5);
		c1.addProducto(p6);
		c1.addProducto(p7);
		c1.addProducto(p8);
		//c1.addProducto(p9);
		//c1.addProducto(p10);
		//c1.addProducto(p11);
		
		v1.addProductVendidos(p1);
		v1.addProductVendidos(p2);
		v1.addProductVendidos(p3);
		v1.addProductVendidos(p4);
		v1.addProductVendidos(p5);
		v1.addProductVendidos(p6);
		v1.addProductVendidos(p7);
		v1.addProductVendidos(p8);
		//v1.addProductVendidos(p9);
		//v1.addProductVendidos(p10);
		
		v1.addProductEnVenta(p11);
		
		//Recargo dinero
		c1.recargarDinero(800.0);
		
		//Hago trato
		Trato t1 = new Trato(c1, v1, p11);
		t1.validar(v2);
		t1.validar(c1);
		
		//Nuevo trato (peta)
		Trato t2 = new Trato(c1, v1, p11);
		t2.validar(c1);
		t2.validar(v1);
		
		//Muestro estadísticas
		System.out.println("ESTADÍSTICAS:");
		System.out.println("Más caro: " + Producto.getMasCaro().getNombre());
		System.out.println("Precio: " + Producto.getMasCaro().getPrecio());
		System.out.println("----------------------------------");
		System.out.println("Más barato: " + Producto.getMasBarato().getNombre());
		System.out.println("Precio: " + Producto.getMasBarato().getPrecio());
		System.out.println("----------------------------------");
		System.out.println("Último vendido: " + Producto.getUltimoVendido().getNombre());
		System.out.println("Precio: " + Producto.getUltimoVendido().getPrecio());
		
		
		
		
		
		
		
	}

}
