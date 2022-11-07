package com.jacaranda.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jacaranda.categoria.Categoria;


public class CRUDCategoria {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;
	
	public CRUDCategoria() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}
	public Categoria readCategoria(int id_categoria) {
		Categoria c=null;
		try {
			c= (Categoria) session.get(Categoria.class,id_categoria);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}
	public boolean addCategoria(Categoria c) {
		boolean resultado=false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	public boolean deleteCategoria(Categoria c) {
		boolean resultado=false;
		try {
			Categoria cNew= (Categoria) session.get(Categoria.class,c.getId_categoria());
			session.getTransaction().begin();
			session.delete(cNew);	
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
	public List<Categoria> loadList(){

		List<Categoria> list= new ArrayList<>();
		Query query=session.createQuery("SELECT c FROM CATEGORIA c");
		list= query.getResultList();
		return list;
		
	}
	
	public boolean updateCategoria(Categoria c, String nombre, String descripcion) {
		boolean resultado=false;
		try {
			Categoria cNew= (Categoria) session.get(Categoria.class,c.getId_categoria());
			cNew.setNombre(nombre);
			cNew.setDescripcion(descripcion);
			
			session.getTransaction().begin();
			session.saveOrUpdate(cNew);
			session.getTransaction().commit();
			resultado=true;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
}
