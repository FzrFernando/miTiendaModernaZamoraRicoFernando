package com.jacaranda.producto;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jacaranda.venta.Venta;

//CREATE TABLE PRODUCTO(
//		ID_PRODUCTO NUMERIC(5) UNIQUE,
//		NOMBRE VARCHAR(50) UNIQUE,
//		DESCRIPCION VARCHAR(150),
//		PRECIO FLOAT(5,2),
//		ID_CATEGORIA NUMERIC(5),
//		CONSTRAINT PK_PRODUCTO PRIMARY KEY(ID_PRODUCTO),
//		CONSTRAINT FK_PRODUCTO FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID_CATEGORIA)
//		);


@Entity (name="PRODUCTO")
public class Producto {

	@Id
	@Column (name="ID_PRODUCTO")
	private int id_producto;
	@Column (name="NOMBRE")
	private String nombre;
	@Column (name="DESCRIPCION")
	private String descripcion;
	@Column (name="PRECIO")
	private float precio;
	@Column (name="ID_CATEGORIA")
	private int id_categoria;
	@OneToMany(mappedBy = "ID_VENTA", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> listaVenta;
	


	public Producto(int id_producto, String nombre, String descripcion, float precio, int id_categoria) {
		super();
		this.id_producto = id_producto;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.id_categoria = id_categoria;
	}


	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id_producto;
	}

	public void setId(int id_producto) {
		this.id_producto = id_producto;
	}


	public int getId_producto() {
		return id_producto;
	}


	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	
	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
	}


	public int getId_categoria() {
		return id_categoria;
	}


	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	
	public List<Venta> getListaVenta() {
		return listaVenta;
	}


	public void setListaVenta(List<Venta> listaVenta) {
		this.listaVenta = listaVenta;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id_producto);
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return id_producto == other.id_producto;
	}


	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", id_categoria=" + id_categoria + ", listaVenta=" + listaVenta + "]";
	}



	
}
