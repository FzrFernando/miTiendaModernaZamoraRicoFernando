package com.jacaranda.crud;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jacaranda.producto.Producto;


public class CRUDProducto {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;
	
	public CRUDProducto() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public Producto readProducto(int id) {
		Producto p = null;
		
		try {
			p = session.get(Producto.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return p;
	}
	
	public List<Producto> loadList(){
		List<Producto> list = new ArrayList<>();
		Query query = session.createQuery("SELECT p FROM PRODUCTO p");
		list = query.getResultList();
		return list;
		
	}
	
	public boolean addProducto(Producto p) {
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
	
	public boolean deleteProducto(Producto p) {
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
	
	public boolean updateProducto(Producto p, String nombre, String descripcion, float price, int id_categoria) {
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
