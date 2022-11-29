package com.jacaranda.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



//CREATE TABLE VENTA(
//		USUARIO VARCHAR(50),
//		ID_PRODUCTO NUMERIC(5),
//		CANTIDAD NUMERIC(10),
//		PRECIO FLOAT(5,2),
//		FECHA_VENTA DATE,
//		CONSTRAINT PK_VENTA PRIMARY KEY(USUARIO,ID_PRODUCTO,FECHA_VENTA),
//		CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO),
//		CONSTRAINT FK_VENTA_USUARIO FOREIGN KEY (USUARIO) REFERENCES USUARIO(USUARIO)
//		);

@Entity(name = "VENTA")
@IdClass(Venta_Id.class)
public class Venta {
	@Id
	@ManyToOne
	@JoinColumn(name = "usuario")
	private Users usuario;
	@Id
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto id_producto;
	@Id
	@Column(name = "fecha_venta")
	private LocalDateTime fecha_venta;
	@Column(name = "CANTIDAD")
	private int cantidad;
	@Column(name = "PRECIO")
	private float precio;
	
	public Venta(Users usuario, Producto id_producto, LocalDateTime fecha_venta, int cantidad, float precio) {
		super();
		this.usuario = usuario;
		this.id_producto = id_producto;
		this.fecha_venta = fecha_venta;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users getUsuario() {
		return usuario;
	}

	public void setUsuario(Users usuario) {
		this.usuario = usuario;
	}

	public Producto getId_producto() {
		return id_producto;
	}

	public void setId_producto(Producto id_producto) {
		this.id_producto = id_producto;
	}

	public LocalDateTime getFecha_venta() {
		return fecha_venta;
	}

	public void setFecha_venta(LocalDateTime fecha_venta) {
		this.fecha_venta = fecha_venta;
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
		Venta other = (Venta) obj;
		return Objects.equals(fecha_venta, other.fecha_venta) && Objects.equals(id_producto, other.id_producto)
				&& Objects.equals(usuario, other.usuario);
	}

	@Override
	public String toString() {
		return "Venta [usuario=" + usuario + ", id_producto=" + id_producto + ", fecha_venta=" + fecha_venta
				+ ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	
	
	
	
	
	
	
}


