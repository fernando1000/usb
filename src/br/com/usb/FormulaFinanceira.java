package br.com.usb;

public class FormulaFinanceira {
	
	static public double devolvePagamento(double taxa, int numeroParcelas, double valorPresente, double valorFuturo, int tipo) {
		return -taxa * (valorPresente * Math.pow(1 + taxa, numeroParcelas) + valorFuturo) / ((1 + taxa*tipo) * (Math.pow(1 + taxa, numeroParcelas) - 1));
	}
	
	static public double devolveValorFuturo(double taxa, int numeroParcelas, double pagamentoPorMes, double valorPresente, int tipo) {
		return -(valorPresente * Math.pow(1 + taxa, numeroParcelas) + pagamentoPorMes * (1+taxa*tipo) * (Math.pow(1 + taxa, numeroParcelas) - 1) / taxa);
	}
	
	static public double devolveNumeroDeParcelas(double taxa, double pagamentoPorMes, double valorPresente, double valorFuturo, int tipo) {
		
	  double num = pagamentoPorMes * (1 + taxa * tipo) - valorFuturo * taxa;
	  double den = (valorPresente * taxa + pagamentoPorMes * (1 + taxa * tipo));
		  
	  return Math.log(num / den) / Math.log(1 + taxa);
	}

}