package edu.pe.unsch.entities;

public class Item {

	private Producto producto;
	private int stock;
	
	
	public Item() {
		super();
		}
	
	
	public Item(Producto producto, int stock) {
		super();
		this.producto = producto;
		this.stock = stock;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
}
