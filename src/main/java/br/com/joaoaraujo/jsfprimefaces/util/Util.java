package br.com.joaoaraujo.jsfprimefaces.util;

public class Util {

	public static boolean isInt(String value) {
		try{
			Integer.parseInt(value);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
}
