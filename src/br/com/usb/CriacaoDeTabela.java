package br.com.usb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class CriacaoDeTabela {

	public static String criaTabelaIndividual(Class<?> classe){
		
		StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
				
		sb.append("###############################"+ classe.getSimpleName() +"###############################################");
		sb.append("\n");
		
		for(Field field : classe.getDeclaredFields()){
			
			field.setAccessible(true);
			
		sb.append("public static final String COLUMN_" + field.getName().toUpperCase() + " = '" +  field.getName()  +"';"); 
		sb.append("\n");
		
			if(field.getType() == int.class){
			
			sb2.append("COLUMN_"+field.getName().toUpperCase() + " + ' integer, ' +");
			sb2.append("\n");
			}
			else{
			sb2.append("COLUMN_"+field.getName().toUpperCase() + " + ' text, ' +");
			sb2.append("\n");
			}
		}		
		sb.append("public static final String TABLE_" + classe.getSimpleName().toUpperCase() + " = '" + classe.getSimpleName() + "';");	
		sb.append("\n");
		sb.append("private static final String " + classe.getSimpleName().toUpperCase() + "_CREATE = 'create table ' + TABLE_"+ classe.getSimpleName().toUpperCase() + " + ");
		sb.append("\n");
		sb.append("'('" + " +");
		sb.append("\n");
		
		sb2.deleteCharAt(sb2.length() - 6);
		sb2.append("')';");
		
		sb.append(sb2);
		sb.append("\n");
		
		return sb.toString();
	}
	
	public static List<String> devolveListaDeClasses() {

		List<String> lista = new ArrayList<String>();

		try {

			for (String classpathEntry : System.getProperty("java.class.path").split(System.getProperty("path.separator"))) {

				if (classpathEntry.endsWith("posvendasharedlib.jar")) {

					File jar = new File(classpathEntry);

					JarInputStream is = new JarInputStream(new FileInputStream(jar));

					JarEntry entry;

					while ((entry = is.getNextJarEntry()) != null) {

						if (entry.getName().startsWith("br/com/consigaz/posvendasharedlib/model")) {

							String tt = entry.getName();

							String aa = tt.replaceAll("/", ".");

							StringBuilder sb = new StringBuilder();

							sb.append(aa);

							int cc = aa.length() - 6;

							sb.delete(cc, aa.length());

							lista.add(sb.toString());
						}
					}
					is.close();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public static void criaTodasTabelasDeUmalista(){
		
		StringBuilder sb = new StringBuilder();
			
		try {

			for(String nomeDaClasse : devolveListaDeClasses()){
		   
			Class<?> classe = Class.forName(nomeDaClasse);
             
	        sb.append(criaTabelaIndividual(classe));
			}
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		escreveEmTxt(sb.toString());
	}
	
	public static void escreveEmTxt(String texto){
		
		String caminho = "c:/temp/tabelas.txt"; 
		
		File file = new File(caminho);
		
		try {
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
					   writer.write(texto);
					   writer.flush();
					   writer.close();

		System.out.println("Gerou as tabelas no caminho: "+ caminho);	
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
