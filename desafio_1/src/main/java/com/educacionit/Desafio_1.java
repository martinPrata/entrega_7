package com.educacionit;

import java.util.ArrayList;
import java.util.Scanner;

public class Desafio_1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Cantidad de alumnos a procesar: ");
		int cantidadAlumnos = scanner.nextInt();
		
		ArrayList<String> nombres = new ArrayList<>();
		ArrayList<String> apellidos = new ArrayList<>();
		ArrayList<Double> notasMaximas = new ArrayList<>();
		ArrayList<Double> notasMinimas = new ArrayList<>();
		ArrayList<Double> promedios = new ArrayList<>();

		
		for (int i = 0; i < cantidadAlumnos; i++) {
			System.out.println("Ingrese los datos para el " + (i+1) + "ª alumno: ");
			System.out.println("Nombre: ");
			String nombre = scanner.next();
			System.out.println("Apellido: ");
			String apellido = scanner.next();
			
			ArrayList<Double> notasExamenes = new ArrayList<>();
			
			while (true) {
				System.out.println("Ingrese el numero del examen (ingrese 0 si no tiene mas que cargar de este alumno): ");
				int numeroExamen = scanner.nextInt();
				
				if (numeroExamen == 0) {
					break;
				}
				if (numeroExamen < 1) {
					System.out.println("El numero de examen es invalido. Por favor ingrese numeros mayores a 0");
					continue;
				}
				
				System.out.println("Nota examen: ");
				double nota = scanner.nextDouble();
				
				if (nota >= 1 && nota <= 10) {
					notasExamenes.add(nota);
				} else {
					System.out.println("La nota debe ser entre 1 y 10");
				}
			}
			
			double promedio = calcularPromedio(notasExamenes);
			double notaMaxima = obtenerNotaMaxima(notasExamenes);
			double notaMinima = obtenerNotaMinima(notasExamenes);
			
			nombres.add(nombre);
			apellidos.add(apellido);
			notasMaximas.add(notaMaxima);
			notasMinimas.add(notaMinima);
			promedios.add(promedio);
		}
		
		mostrarResultados(nombres, apellidos, notasMaximas, notasMinimas, promedios);
		
	}
	
	private static double calcularPromedio(ArrayList<Double> notas) {
		double suma = 0;
		for (Double nota : notas) {
			suma += nota;
		}
		
		return notas.isEmpty() ? 0 : (suma / notas.size());
		
	}
	
	private static double obtenerNotaMaxima(ArrayList<Double> notas) {
		if (notas.isEmpty()) {
			return 0;
		}
		double maxima = notas.get(0);
		
		for (double nota : notas) {
			if (nota > maxima) {
				maxima = nota;
			}
		}
		return maxima;
	}
	
	private static double obtenerNotaMinima(ArrayList<Double> notas) {
		if (notas.isEmpty()) {
			return 0;
		}
		double minima = notas.get(0);
		
		for (double nota : notas) {
			if (minima > nota) {
				minima = nota;
			}
		}
		return minima;
	}
	
	private static void mostrarResultados(ArrayList<String> nombres, ArrayList<String> apellidos, ArrayList<Double> notasMaximas, ArrayList<Double> notasMinimas, ArrayList<Double> promedios) {
		ArrayList<Integer> indicesMax = obtenerIndicesMaximos(notasMaximas);
		ArrayList<Integer> indicesMin = obtenerIndicesMinimos(notasMinimas);
		
		System.out.println("1- Alumno/s con la calificacion mas alta: ");
		mostrarAlumnos(nombres, apellidos, notasMaximas, indicesMax);
		
		System.out.println("2- Alumno/s con la calificacion mas baja: ");
		mostrarAlumnos(nombres, apellidos, notasMinimas, indicesMin);
		
		System.out.println("3- Alumno/s que promocionan (promedio >= 7): ");
		mostrarAlumnosConPromedio(nombres, apellidos, promedios, 7, true);
		
		System.out.println("4- Alumno/s que deben recursar la materia (promedio < 7): ");
		mostrarAlumnosConPromedio(nombres, apellidos, promedios, 7, false);
		
	}
	
	private static ArrayList<Integer> obtenerIndicesMaximos(ArrayList<Double> lista){
		ArrayList<Integer> indicesMax = new ArrayList<>();
		double maximo = 0;
		
		for (int i = 0; i < lista.size(); i++) {
			double nota = lista.get(i);
			if (maximo < nota) {
				maximo = nota;
				indicesMax.clear();
				indicesMax.add(i);
			} else if (nota == maximo) {
				indicesMax.add(i);
			}
		}
		return indicesMax;
	}
	
	
	private static ArrayList<Integer> obtenerIndicesMinimos(ArrayList<Double> lista){
		ArrayList<Integer> indicesMin = new ArrayList<>();
		double minimo = 10;
		
		for (int i = 0; i < lista.size(); i++) {
			double nota = lista.get(i);
			if (nota < minimo) {
				minimo = nota;
				indicesMin.clear();
				indicesMin.add(i);
			} else if (nota == minimo) {
				indicesMin.add(i);
			}
		}
		return indicesMin;
	}
	
	private static void mostrarAlumnos(ArrayList<String> nombres,ArrayList<String> apellidos, ArrayList<Double> notas, ArrayList<Integer> indices) {
		for (int indice : indices) {
			System.out.println(nombres.get(indice) + " " + apellidos.get(indice) + " - Nota: " + notas.get(indice));
		}
	}
	
	private static void mostrarAlumnosConPromedio(ArrayList<String> nombres,ArrayList<String> apellidos, ArrayList<Double> promedios, double limite, boolean promocion) {
		for (int i = 0;  i < promedios.size(); i++) {
			if ((promocion && promedios.get(i) >= limite) || (!promocion && promedios.get(i) < limite)) {
				System.out.println(nombres.get(i) + " " + apellidos.get(i) + " - Promedio: " + promedios.get(i));
		}
	}
	}
}
