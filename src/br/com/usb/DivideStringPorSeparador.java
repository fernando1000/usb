package br.com.usb;

import java.util.ArrayList;

public class DivideStringPorSeparador {

	public ArrayList<String> dividir(String stringASeparar) {

		ArrayList<String> arrayList_itens = new ArrayList<String>();

		String listaComItens = stringASeparar;

		String[] arrayDaListaComItens = listaComItens.split(",");

		for (String itemDaLista : arrayDaListaComItens) {

			arrayList_itens.add(itemDaLista);
		}
		return arrayList_itens;
	}

}
