package com.jacaranda.crud;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.jacaranda.users.Users;

public class CRUDUsers {
	private StandardServiceRegistry sr;
	private SessionFactory sf;
	private Session session;

	public CRUDUsers() {
		super();
		sr = new StandardServiceRegistryBuilder().configure().build();
		sf = new MetadataSources(sr).buildMetadata().buildSessionFactory();
		session = sf.openSession();
	}

	public Users readUser(String usuario) {
		Users u = null;
		try {
			u = (Users) session.get(Users.class, usuario);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return u;
	}

	public List<Users> loadList() {

		List<Users> list = new ArrayList<>();
		Query query = session.createQuery("SELECT u FROM USUARIO u");
		list = query.getResultList();
		return list;
		
	}

}

