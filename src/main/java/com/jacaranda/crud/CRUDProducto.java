package com.jacaranda.crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jacaranda.model.Producto;



public class CRUDProducto {
	
	public static Producto readProducto(int id) {
		Session session = ConnectionBD.getSession();
		Producto p = null;
		
		try {
			p = session.get(Producto.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public static List<Producto> loadList(){
		Session session = ConnectionBD.getSession();
		List<Producto> list = new ArrayList<>();
		Query query = session.createQuery("SELECT p FROM PRODUCTO p");
		list = query.getResultList();
		return list;
		
	}
	
	public static boolean addProducto(Producto p) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(p);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public static boolean deleteProducto(Producto p) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			
			Producto pNew = session.get(Producto.class,p.getId());
			session.getTransaction().begin();
			session.delete(pNew);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
//	CREATE TABLE PRODUCTO(
//			ID_PRODUCTO NUMERIC(5) UNIQUE,
//			NOMBRE VARCHAR(50) UNIQUE,
//			DESCRIPCION VARCHAR(150),
//			PRECIO FLOAT(5,2),
//			ID_CATEGORIA NUMERIC(5),
//			CONSTRAINT PK_PRODUCTO PRIMARY KEY(ID_PRODUCTO),
//			CONSTRAINT FK_PRODUCTO FOREIGN KEY (ID_CATEGORIA) REFERENCES CATEGORIA(ID_CATEGORIA)
//			);
	
	public static boolean updateProducto(Producto p, String nombre, String descripcion, float price, int id_categoria) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			
			Producto pNew = session.get(Producto.class,p.getId());
			pNew.setNombre(nombre);;
			pNew.setDescripcion(descripcion);
			pNew.setPrecio(price);
			pNew.setId_categoria(id_categoria);
			
			session.getTransaction().begin();
			session.saveOrUpdate(pNew);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	


}
