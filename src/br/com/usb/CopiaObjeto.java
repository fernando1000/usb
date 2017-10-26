package br.com.usb;

import java.lang.reflect.Field;

public class CopiaObjeto {

	public Object devolveObjetoCopiado(Object objeto_DE, Object objeto_PARA) {

		try {
			Class<?> classeDoObjeto_DE = objeto_DE.getClass();
			Class<?> classeDoObjeto_PARA = objeto_PARA.getClass();

			for (Field field_DE : classeDoObjeto_DE.getDeclaredFields()) {

				field_DE.setAccessible(true);

				if (!field_DE.getName().contains("COLUMN")) {

					for (Field field_PARA : classeDoObjeto_PARA.getDeclaredFields()) {

						field_PARA.setAccessible(true);

						if (!field_PARA.getName().contains("COLUMN")) {

							if (field_DE.getName().equals(field_PARA.getName())) {

								if (field_DE.getType() == int.class) {

									field_PARA.setInt(objeto_PARA, field_DE.getInt(objeto_DE));
								} else if (field_DE.getType() == double.class) {

									field_PARA.setDouble(objeto_PARA, field_DE.getDouble(objeto_DE));
								} else if (field_DE.getType() == float.class) {

									field_PARA.setFloat(objeto_PARA, field_DE.getFloat(objeto_DE));
								} else {

									if (null == field_DE.get(objeto_DE)) {

										field_PARA.set(objeto_PARA, "equals(null)");
									} else {
										field_PARA.set(objeto_PARA, field_DE.get(objeto_DE));
									}
								}

								break;
							}
						}
					}

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return objeto_PARA;
	}

}
