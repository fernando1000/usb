package br.com.usb;

import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONObject;
import android.content.Context;
import android.widget.Toast;

public class JsonUtil2 {
		
	public boolean insereInformacoesDoJsonNoBancoDeDados(Context context, JSONObject jSONObjectResposta, Dao dao, Class<?> classeHOLDER) {
		
		boolean deuErro = false;
		
		try {
			
		Class<?> classe = classeHOLDER;
		
			if(jSONObjectResposta.has(classe.getSimpleName())){
				
				JSONObject obj_ClasseProgrContaSIM = (JSONObject) jSONObjectResposta.get(classe.getSimpleName());
				
				for(Field field : classe.getDeclaredFields()){
					
					field.setAccessible(true);
					
					if(!field.getName().contains("COLUMN")){
						
						if(obj_ClasseProgrContaSIM.has(field.getName())){
				
							Class<?> classeEncontrada = Class.forName("mobile.contasim.model."+field.getName());
								
							JSONArray jSONArray = obj_ClasseProgrContaSIM.getJSONArray(field.getName());
								
							deuErro = VarreJsonArray.insereDados(classeEncontrada, jSONArray, dao);
						}						
					}
				}			
			}
			else{				
				Toast.makeText(context, "Não encontrou a classe "+classe.getSimpleName(), Toast.LENGTH_LONG).show();
			}
		
		} 
		catch (Exception e) {
			
			deuErro = true;
			e.printStackTrace();
		}

		return deuErro;
	}

}
