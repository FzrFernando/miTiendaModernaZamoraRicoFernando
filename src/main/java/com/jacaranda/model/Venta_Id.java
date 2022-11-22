package com.jacaranda.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


public class Venta_Id implements Serializable{
	private static final long serialVersionUID = 1L;
	private String usuario;
	private int id_producto;
	private LocalDate fecha_venta;
	
	public Venta_Id(String usuario, int id_producto, LocalDate fecha_venta) {
		super();
		this.usuario = usuario;
		this.id_producto = id_producto;
		this.fecha_venta = fecha_venta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha_venta, id_producto, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta_Id other = (Venta_Id) obj;
		return Objects.equals(fecha_venta, other.fecha_venta) && id_producto == other.id_producto
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Venta_Id [usuario=" + usuario + ", id_producto=" + id_producto + ", fecha_venta=" + fecha_venta + "]";
	}
	
	
}
