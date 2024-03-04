package com.educacionit;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Avion avion1 = new Avion("Mirage M-III EA", "Carlos Fernandez", 6);
		Helicoptero helicoptero1 = new Helicoptero("Bell 212", "Matias Suarez", 2);
		
		List<VoladorYPiloto> listaVoladores = new ArrayList<>();
		listaVoladores.add(avion1);
		listaVoladores.add(helicoptero1);
		
		for (VoladorYPiloto volador : listaVoladores) {
			System.out.println("Informacion del volador: " + volador);
            if (volador.puedeAterrizarPista1()) {
                System.out.println("El volador con los datos " + volador + " puede aterrizar en la pista 1.");
            } else {
                boolean autorizacionPista2 = volador.solicitarAutorizacionPista2();
                if (autorizacionPista2) {
                    System.out.println("El volador con los datos " + volador + " puede aterrizar en la pista 2");
                } else {
                    System.out.println("El volador con los datos " + volador + " no esta autorizado para aterrizar.");
                }
            }
		
	}

	}
}
