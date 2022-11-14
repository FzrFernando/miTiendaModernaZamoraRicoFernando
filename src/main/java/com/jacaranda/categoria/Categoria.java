package com.jacaranda.categoria;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.jacaranda.producto.Producto;

//CREATE TABLE CATEGORIA(
//		ID_CATEGORIA NUMERIC(5) UNIQUE,
//		NOMBRE VARCHAR(50),
//		DESCRIPCION VARCHAR(150),
//		CONSTRAINT PK_CATEGORIA PRIMARY KEY(ID_CATEGORIA)
//		);

@Entity(name = "CATEGORIA")
public class Categoria {

	@Id
	@Column(name = "ID_CATEGORIA")
	private int id_categoria;
	@Column(name = "NOMBRE")
	private String nombre;
	@Column(name = "DESCRIPCION")
	private String descripcion;
	@OneToMany(mappedBy = "ID_PRODUCTO", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Producto> listaProducto;

	public Categoria(int id_categoria, String nombre, String descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public Categoria() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
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

	public List<Producto> getShoesList() {
		return listaProducto;
	}

	public void setProductoList(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_categoria);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return id_categoria == other.id_categoria;
	}

	@Override
	public String toString() {
		return "Categoria [id_categoria =" + id_categoria + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", ProductoList=" + listaProducto + "]";
	}

}
