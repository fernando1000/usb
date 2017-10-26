package br.com.usb;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PegaDadosDispositivo {

	private Context context;
	
	public PegaDadosDispositivo(Context _context){
		this.context = _context;
	}
	
	public String pegaIMEI() {
		
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

		if (telephonyManager.getDeviceId() == null) {
			return "000000000000000";
			      //354988056543729  
		}else{
			return telephonyManager.getDeviceId();
		}
	}

	public String pegaCHIP() {
		
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

		if (telephonyManager.getSimSerialNumber() == null) {
			return "xxx";
		}else{
			return telephonyManager.getSimSerialNumber();
		}
	}

}
