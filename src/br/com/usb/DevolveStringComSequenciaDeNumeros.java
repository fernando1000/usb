package br.com.usb;

import java.util.List;

public class DevolveStringComSequenciaDeNumeros {

	public static String devolve(List<Integer> lista) {

		int tamanhoDaListaMenos1 = lista.size() - 1;

		String sequenciaDeNumeros = "";

		for (int i = 0; i < lista.size(); i++) {

			if (tamanhoDaListaMenos1 == i) {

				sequenciaDeNumeros = sequenciaDeNumeros + String.valueOf(lista.get(i));
			} else {
				sequenciaDeNumeros = sequenciaDeNumeros + String.valueOf(lista.get(i) + ",");
			}
		}
		return sequenciaDeNumeros;
	}
}
