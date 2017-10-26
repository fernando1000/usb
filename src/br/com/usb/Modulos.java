package br.com.usb;

public class Modulos {

	public String getModulo11(String campo, int type) {
		// Modulo 11 - 234567 (type = 7)
		// Modulo 11 - 23456789 (type = 9)

		int multiplicador = 2;
		int multiplicacao = 0;
		int soma_campo = 0;

		for (int i = campo.length(); i > 0; i--) {
			multiplicacao = Integer.parseInt(campo.substring(i - 1, i))
					* multiplicador;

			soma_campo = soma_campo + multiplicacao;

			multiplicador++;
			if (multiplicador > 7 && type == 7)
				multiplicador = 2;
			else if (multiplicador > 9 && type == 9)
				multiplicador = 2;
		}

		int dac = 11 - (soma_campo % 11);

		if (dac > 9 && type == 7)
			dac = 0;
		else if ((dac == 0 || dac == 1 || dac > 9) && type == 9)
			dac = 1;

		return ((Integer) dac).toString();
	}

	public String getModulo10(String campo) {

		int multiplicador = 2;
		int multiplicacao = 0;
		int soma_campo = 0;

		for (int i = campo.length(); i > 0; i--) {
			multiplicacao = Integer.parseInt(campo.substring(i - 1, i))
					* multiplicador;

			if (multiplicacao >= 10) {
				multiplicacao = Integer.parseInt(String.valueOf(multiplicacao)
						.substring(0, 1))
						+ Integer.parseInt(String.valueOf(multiplicacao)
								.substring(1, 2));
			}
			soma_campo = soma_campo + multiplicacao;

			if (multiplicador == 1)
				multiplicador = 2;
			else
				multiplicador = 1;
		}
		int dac = 10 - (soma_campo % 10);

		if (dac > 9)
			dac = 0;

		return ((Integer) dac).toString();
	}

}
