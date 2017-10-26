package br.com.usb;

import java.lang.reflect.Field;
import java.sql.ResultSet;

public class PreencheObjetoUsandoResultSet {

	public static Object devolveObjetoPreenchido(Class<?> classe, ResultSet resultSet) {

		Object objectInstance = null;

		try {
			objectInstance = classe.getConstructor().newInstance();

			for (Field field : classe.getDeclaredFields()) {

				field.setAccessible(true);

				if (!field.getName().contains("COLUMN")) {

					if (field.getType() == int.class || field.getType() == java.lang.String.class) {

						if (field.getType() == int.class) {

							field.setInt(objectInstance, resultSet.getInt(field.getName()));
						}
						else {
							
							if (null == resultSet.getString(field.getName())) {

								field.set(objectInstance, "equals(null)");
							} 
							else {
								field.set(objectInstance, resultSet.getString(field.getName()));
							}
						}		
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objectInstance;
	}
}
