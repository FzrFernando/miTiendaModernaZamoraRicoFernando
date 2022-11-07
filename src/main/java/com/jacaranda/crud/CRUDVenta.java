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

import com.jacaranda.venta.Venta;



public class CRUDVenta {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;
	
	public CRUDVenta() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	
	public Venta readVenta(int id) {
		Venta v = null;
		
		try {
			v = session.get(Venta.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return v;
	}
	
	public List<Venta> loadList(){
		List<Venta> list = new ArrayList<>();
		Query query = session.createQuery("SELECT v FROM VENTA v");
		list = query.getResultList();
		return list;
		
	}
	
	public boolean addVenta(Venta v) {
		boolean resultado = false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(v);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	public boolean deleteVenta(Venta v) {
		boolean resultado = false;
		try {
			
			Venta vNew = session.get(Venta.class,v.getId_venta());
			session.getTransaction().begin();
			session.delete(vNew);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	
	//CREATE TABLE VENTA(
//	ID_VENTA NUMERIC(5),
//	USUARIO VARCHAR(50),
//	ID_PRODUCTO NUMERIC(5),
//	CANTIDAD NUMERIC(10),
//	PRECIO FLOAT(5,2),
//	FECHA_VENTA DATE,
//	CONSTRAINT PK_VENTA PRIMARY KEY(ID_VENTA),
//	CONSTRAINT FK_VENTA_PRODUCTO FOREIGN KEY (ID_PRODUCTO) REFERENCES PRODUCTO(ID_PRODUCTO),
//	CONSTRAINT FK_VENTA_USUARIO FOREIGN KEY (USUARIO) REFERENCES USUARIO(USUARIO)
//	);
	
	public boolean updateVente(Venta v, String usuario, int id_producto, int cantidad, float precio, LocalDate fecha_venta) {
		boolean resultado = false;
		try {
			
			Venta vNew = session.get(Venta.class,v.getId_venta());
			vNew.setUsuario(usuario);
			vNew.setId_producto(id_producto);
			vNew.setCantidad(cantidad);
			vNew.setPrecio(precio);
			vNew.setFecha_venta(fecha_venta);
			
			
			session.getTransaction().begin();
			session.saveOrUpdate(vNew);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
}
