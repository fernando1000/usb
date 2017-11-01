package br.com.usb;

import android.view.Menu;

public class IpDNS {

	public static final String URL_SIVA_REST = "http://siva.consigaz.com.br:9090/Prospects_rest_service";
	private static final String URL_SIVA2_REST = "http://siva2.consigaz.com.br:9090/Prospects_rest_service";
	private static final String URL_SIVA3_REST = "http://siva3.consigaz.com.br:9090/Prospects_rest_service";

	public static String acaoLinkDaOI(Menu menu){
		
		menu.getItem(0).setEnabled(false); 			 
		menu.getItem(1).setEnabled(true);
		menu.getItem(2).setEnabled(true);		
		
		return URL_SIVA_REST;
	}

	public static String acaoLinkDaVOGEL(Menu menu){

		menu.getItem(0).setEnabled(true);		
		menu.getItem(1).setEnabled(false);		
		menu.getItem(2).setEnabled(true);	
		
		return URL_SIVA2_REST;	
	}

	public static String acaoLinkDaWCS(Menu menu){
	
		menu.getItem(0).setEnabled(true);		
		menu.getItem(1).setEnabled(true);		
		menu.getItem(2).setEnabled(false);
		
		return URL_SIVA3_REST;
	}

}
