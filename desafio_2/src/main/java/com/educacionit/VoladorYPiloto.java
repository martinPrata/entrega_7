package com.educacionit;

import java.util.Scanner;

public abstract class VoladorYPiloto {
	protected String modelo;
	protected String nombrePiloto;
	protected int experienciaPiloto;
	public VoladorYPiloto(String modelo, String nombrePiloto, int experienciaPiloto) {
		this.modelo = modelo;
		this.nombrePiloto = nombrePiloto;
		this.experienciaPiloto = experienciaPiloto;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getNombrePiloto() {
		return nombrePiloto;
	}
	public void setNombrePiloto(String nombrePiloto) {
		this.nombrePiloto = nombrePiloto;
	}
	public int getExperienciaPiloto() {
		return experienciaPiloto;
	}
	public void setExperienciaPiloto(int experienciaPiloto) {
		this.experienciaPiloto = experienciaPiloto;
	}
	
	public boolean puedeAterrizarPista1() {
		return experienciaPiloto > 5;
	}
	
	public boolean solicitarAutorizacionPista2() {
		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Se recibio la solicitud para aterrizar en la pista 2 del siguiente volador:");
			System.out.println("Modelo del volador: " + this.modelo);
			System.out.println("Nombre del piloto: " + this.nombrePiloto);
			
			System.out.print("¿Autoriza el aterrizaje? (s/n): ");
			String respuesta = scanner.nextLine();
			
			if (respuesta.equalsIgnoreCase("s")) {
				return true;
			} else if (respuesta.equalsIgnoreCase("n")) {
				return false;
			} else {
				System.out.println("Respuesta no valida. Por favor ingrese 's' o 'n'");
			}
		}
	}
	
	public void volar() {
		System.out.println("Volando con " + nombrePiloto);
	}
	@Override
	public String toString() {
		return "modelo=" + modelo + ", nombrePiloto=" + nombrePiloto + ", experienciaPiloto="
				+ experienciaPiloto + "]";
	}
	
	
	
}
