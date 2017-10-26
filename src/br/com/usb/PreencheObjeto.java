package br.com.usb;

import java.lang.reflect.Field;
import android.database.Cursor;

public class PreencheObjeto {

	public static Object preencheObjetoUsandoCursor(Class<?> classe, Cursor cursor) {

		Object objeto = null;

		try {
			objeto = classe.getConstructor().newInstance();

			for (Field atributo : classe.getDeclaredFields()) {

				atributo.setAccessible(true);

				if (!atributo.getName().contains("COLUMN")) {

					if (atributo.getType() == int.class) {

						atributo.setInt(objeto, cursor.getInt(cursor.getColumnIndex(atributo.getName())));
					} else {
						atributo.set(objeto, cursor.getString(cursor.getColumnIndex(atributo.getName())));
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objeto;
	}
	
}
