package com.jacaranda.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Carrito {
	public List<ItemCarrito> carrito = new ArrayList<ItemCarrito>();

	public Carrito() {
		super();
		
	}


	public boolean addItem(ItemCarrito c) {
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
	
	public boolean updateItem(ItemCarrito i, int c) {
		boolean resultado = false;
		
		try {
			i = this.carrito.get(this.carrito.indexOf(i));
			i.setCantidad(i.getCantidad()+c);
			resultado =true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
			
		return resultado;
	}
	
	public int cantidadProductosTotales() {
		int resultado = 0;
		for(ItemCarrito i : carrito) {
			resultado += i.getCantidad();
		}
		return resultado;
	}
	
	/**
	 * We need this method to control product's stock
	 * 
	 * @param id
	 * @return The amount of products there is in one item specific
	 */
	public int cantidadProductos(int id) {//Preguntar si este método está bien, o se debería hacer de otra forma
		int resultado = 0;
		try {
			ItemCarrito i = new ItemCarrito(id, 0, 0, null);
			int posicion = carrito.indexOf(i);
			resultado=carrito.get(posicion).getCantidad();
		
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
