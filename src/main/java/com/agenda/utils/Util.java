package com.agenda.utils;

public class Util {

	public static boolean validarString(String string) {
		if (string != null && !string.equals("")) {
			return true;
		}
		return false;
	}
	
}
