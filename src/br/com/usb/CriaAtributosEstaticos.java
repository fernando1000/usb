package br.com.usb;

import java.lang.reflect.Field;

public class CriaAtributosEstaticos {

	public static String cria(Class<?> classe) {

		StringBuilder stringBuilder = new StringBuilder();
		
		String inicio = "public static final String COLUMN_";
		
		for (Field field : classe.getDeclaredFields()) {

			field.setAccessible(true);

			String meio = "";
			
			if (field.getType() == int.class) {
				
				meio = "INTEGER_";
			}else{
				meio = "TEXT_";	
			}
			
			String fim = field.getName().toUpperCase() + " = \"" + field.getName() + "\";";
			
			stringBuilder.append(inicio + meio + fim);
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
