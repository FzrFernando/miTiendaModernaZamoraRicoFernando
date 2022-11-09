package com.jacaranda.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.jacaranda.users.Users;

public class CRUDUsers {

	public static Users readUser(String usuario) {
		Session session = ConnectionBD.getSession();
		Users u = null;
		try {
			u = (Users) session.get(Users.class, usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	public static List<Users> loadList() {

		Session session = ConnectionBD.getSession();
		List<Users> list = new ArrayList<>();
		Query query = session.createQuery("SELECT u FROM USUARIO u");
		list = query.getResultList();
		return list;
		
	}
	
	public static boolean addUser(Users u) {
		boolean resultado = false;
		Session session = ConnectionBD.getSession();
		try {
			session.getTransaction().begin();
			session.saveOrUpdate(u);
			session.getTransaction().commit();
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
	}

}

