package com.educacionit;

import java.util.Arrays;

public class CollectionCustom<T> {
	private Object[] array;
	private int size;
	private static final int CAPACIDAD_DEFAULT = 10;

	public CollectionCustom() {
		this.array = new Object[CAPACIDAD_DEFAULT];
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(T elemento) {
		asegurarCapacidad();
		desplazarDerecha();
		array[0] = elemento;
		size++;
	}
	
	public void addLast(T elemento) {
		asegurarCapacidad();
		array[size] = elemento;
		size++;
	}
	
	public void add (T elemento) {
		addLast(elemento);
	}
	
	public T remove(T elemento) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(elemento)) {
				T elementoEliminado = (T) array[i];
				desplazarIzquierda(i);
				size--;
				return elementoEliminado;
			}
		}
		return null;
	}
	
	public void removeAll(T elemento) {
		int i = 0;
		while (i < size) {
			if (array[i].equals(elemento)) {
				desplazarIzquierda(i);
				size--;
			} else {
				i++;
			}
		}
	}
	
	public boolean empty() {
		return size == 0;
	}
	
	private void asegurarCapacidad() {
		if (size == array.length) {
			int nuevaCapacidad = array.length * 2;
			array = Arrays.copyOf(array, nuevaCapacidad);
		}
	}
	
	private void desplazarDerecha() {
		System.arraycopy(array, 0 , array, 1, size);
	}
	
	private void desplazarIzquierda(int indice) {
		System.arraycopy(array, indice +1, array, indice, size - indice - 1);
		array[size - 1] = null;
	}
	
	public String toString() {
		String resultado = "";
		for (int i = 0; i < this.size; i++) {
			resultado += this.array[i] + " ";
		}
		return resultado;
	}
	
}
