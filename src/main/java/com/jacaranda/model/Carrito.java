package com.jacaranda.model;

import java.util.List;
import java.util.Objects;

import org.hibernate.Session;

import com.jacaranda.crud.ConnectionBD;

public class Carrito {
	public List<ItemCarrito> carrito;

	public Carrito() {
		super();
		this.carrito = null;
	}


	public boolean addCarrito(ItemCarrito c) {
		boolean resultado = false;
		try {
			carrito.add(c);
			resultado=true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
		
	}
	
	public boolean delItem(ItemCarrito c) {
		boolean resultado = false;
		try {
			int index= carrito.indexOf(c);
			carrito.remove(index);
			resultado = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return resultado;
		
	}
	

	public List<ItemCarrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<ItemCarrito> carrito) {
		this.carrito = carrito;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(carrito);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrito other = (Carrito) obj;
		return Objects.equals(carrito, other.carrito);
	}

	@Override
	public String toString() {
		return "Carrito [carrito=" + carrito + "]";
	}
	
	
	
}
