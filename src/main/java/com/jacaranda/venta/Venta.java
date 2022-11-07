package com.jacaranda.venta;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

//CREATE TABLE VENTA(
//		ID_VENTA NUMERIC(5),
//		USUARIO VARCHAR(50),
//		ID_PRODUCTO NUMERIC(5),
//		CANTIDAD NUMERIC(10),
//		PRECIO FLOAT(5,2),
//		FECHA_VENTA DATE,
//		CONSTRAINT PK_VENTA PRIMARY KEY(ID_VENTA),
//		CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO),
//		CONSTRAINT FK_VENTA_USUARIO FOREIGN KEY (USUARIO) REFERENCES USUARIO(USUARIO)
//		);

@Entity(name = "VENTA")
public class Venta {
	@Id
	@Column(name = "ID_VENTA")
	private int id_venta;
	@Column(name = "USUARIO")
	private String usuario;
	@Column(name = "ID_PRODUCTO")
	private int id_producto;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@Column(name = "PRECIO")
	private float precio;
	@Column(name = "FECHA_VENTA")
	private LocalDate fecha_venta;
	
	public Venta(int id_venta, String usuario, int id_producto, int cantidad, float precio, LocalDate fecha_venta) {
		super();
		this.id_venta = id_venta;
		this.usuario = usuario;
		this.id_producto = id_producto;
		this.cantidad = cantidad;
		this.precio = precio;
		this.fecha_venta = fecha_venta;
	}

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_venta() {
		return id_venta;
	}

	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalDate getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDate fecha_venta) {
		this.fecha_venta = fecha_venta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_venta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		return id_venta == other.id_venta;
	}

	@Override
	public String toString() {
		return "Venta [id_venta=" + id_venta + ", usuario=" + usuario + ", id_producto=" + id_producto + ", cantidad="
				+ cantidad + ", precio=" + precio + ", fecha_venta=" + fecha_venta + "]";
	}
	
	
	
	
}


