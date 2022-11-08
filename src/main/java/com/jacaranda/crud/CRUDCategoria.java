package com.jacaranda.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jacaranda.categoria.Categoria;


public class CRUDCategoria {

	public Categoria readCategoria(int id_categoria) {
		Session session = ConnectionBD.getSession();
		Categoria c = null;
		try {
			c = (Categoria) session.get(Categoria.class, id_categoria);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return c;
	}

	public boolean addCategoria(Categoria c) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(c);
			session.getTransaction().commit();
			resultado = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public boolean deleteCategoria(Categoria c) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			Categoria cNew = (Categoria) session.get(Categoria.class, c.getId_categoria());
			session.getTransaction().begin();
			session.delete(cNew);
			session.getTransaction().commit();
			resultado = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

	public List<Categoria> loadList() {

		Session session = ConnectionBD.getSession();
		List<Categoria> list = new ArrayList<>();
		Query query = session.createQuery("SELECT c FROM CATEGORIA c");
		list = query.getResultList();
		return list;

	}

	public boolean updateCategoria(Categoria c, String nombre, String descripcion) {
		Session session = ConnectionBD.getSession();
		boolean resultado = false;
		try {
			Categoria cNew = (Categoria) session.get(Categoria.class, c.getId_categoria());
			cNew.setNombre(nombre);
			cNew.setDescripcion(descripcion);

			session.getTransaction().begin();
			session.saveOrUpdate(cNew);
			session.getTransaction().commit();
			resultado = true;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}
}
