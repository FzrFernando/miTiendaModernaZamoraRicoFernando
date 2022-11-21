package com.jacaranda.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class ItemCarrito {
	private int id_articulo;
	private int cantidad;
	private int precio;
	private LocalDateTime fecha;
	
	public ItemCarrito() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ItemCarrito(int id_articulo, int cantidad, int precio, LocalDateTime fecha) {
		super();
		this.id_articulo = id_articulo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha = fecha;
	}



	public int getId_articulo() {
		return id_articulo;
	}

	public void setId_articulo(int id_articulo) {
		this.id_articulo = id_articulo;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}



	@Override
	public int hashCode() {
		return Objects.hash(cantidad, fecha, id_articulo, precio);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemCarrito other = (ItemCarrito) obj;
		return cantidad == other.cantidad && Objects.equals(fecha, other.fecha) && id_articulo == other.id_articulo
				&& precio == other.precio;
	}



	@Override
	public String toString() {
		return "ItemCarrito [id_articulo=" + id_articulo + ", cantidad=" + cantidad + ", precio=" + precio + ", fecha="
				+ fecha + "]";
	}
	
	
	
}
