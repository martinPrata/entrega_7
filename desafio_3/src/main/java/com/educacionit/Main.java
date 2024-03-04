package com.educacionit;

public class Main {

	public static void main(String[] args) {
		
		CollectionCustom<Integer> coleccion = new CollectionCustom<>();
		
		coleccion.addLast(1);
        coleccion.addLast(2);
        coleccion.addLast(3);

        System.out.println("Colección inicial: " + coleccion);

        coleccion.addFirst(0);
        System.out.println("Después de agregar al principio: " + coleccion);

        coleccion.remove(2);
        System.out.println("Después de remover el 2: " + coleccion);

        coleccion.removeAll(3);
        System.out.println("Después de remover todos los 3: " + coleccion);

        System.out.println("¿La colección está vacía? " + coleccion.empty());

        System.out.println("Tamaño de la colección: " + coleccion.size());
    }

}
