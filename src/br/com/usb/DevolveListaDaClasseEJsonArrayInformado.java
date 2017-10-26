package br.com.usb;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class DevolveListaDaClasseEJsonArrayInformado {
	
	public <E> List<E> devolve(Class<E> classe, JSONArray jSONArray) throws Exception {

		List<E> lista = new ArrayList<E>();

		for (int i = 0; i < jSONArray.length(); i++) {

			JSONObject jSONObject = jSONArray.getJSONObject(i);

			Object objectInstance = classe.getConstructor().newInstance();

			for (Field field : classe.getDeclaredFields()) {

				field.setAccessible(true);

				if (!field.getName().contains("COLUMN")) {

					if (field.getType() == int.class) {

						field.setInt(objectInstance, jSONObject.getInt(field.getName()));
					} 
					else if (field.getType() == double.class) {

						field.setDouble(objectInstance, jSONObject.getDouble(field.getName()));
					} 	
					else {
						field.set(objectInstance, jSONObject.getString(field.getName()));
					}
				}
			}
			lista.add((E) objectInstance);
		}
		return lista;
	}

}
