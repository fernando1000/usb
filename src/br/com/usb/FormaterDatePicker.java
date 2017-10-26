package br.com.usb;

public class FormaterDatePicker {

	public String devolveData_ddMMyyyy(int dia, int mes, int ano) {

		int mesCerto = mes + 1;

		String string_dia;
		String string_mes;
		String string_ano = "" + ano;

		if (dia < 10) {

			string_dia = "0" + dia;
		} else {
			string_dia = "" + dia;
		}

		
		if (mesCerto < 10) {

			string_mes = "0" + mesCerto;
		} else {
			string_mes = "" + mesCerto;
		}

		return string_dia + "/" + string_mes + "/" + string_ano; // + "00:00:00"
	}

	public String devolveData_yyyyMMdd(int dia, int mes, int ano) {

		int mesCerto = mes + 1;

		String string_dia;
		String string_mes;
		String string_ano = "" + ano;

		if (dia < 10) {

			string_dia = "0" + dia;
		} else {
			string_dia = "" + dia;
		}

		
		if (mesCerto < 10) {

			string_mes = "0" + mesCerto;
		} else {
			string_mes = "" + mesCerto;
		}

		return string_ano +""+ string_mes +""+ string_dia;
	}

}
