package br.com.joaoaraujo.jsfprimefaces.controller;

import java.util.ArrayList;

public class Primos {

	public static void main(String[] args) {
		int cont;
		ArrayList<Integer> primos = new ArrayList<>();
		for (int i = 41; i <= 5002; i++) {
			cont = 0;
			for (int u = 1; u <= i; u++) {
				if (i % u == 0) {
					cont++;
				}
			}
			if (cont == 2) {
				primos.add(i);
			}
		}
		System.out.println("Numeros primos de 41 a 5002: " + primos);
	}

}
