package br.com.usb;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class DetectaConexao {

	private Context context;

	public DetectaConexao(Context _context) {
		this.context = _context;
	}
	
	public boolean estaConectadoNaInternet() {

		ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

		if (connectivityManager != null) {

			NetworkInfo[] arrayNetworkInfo = connectivityManager.getAllNetworkInfo();

			if (arrayNetworkInfo != null) {

				for (int i = 0; i < arrayNetworkInfo.length; i++) {

					if (arrayNetworkInfo[i].getState() == NetworkInfo.State.CONNECTED) {

						return true;
					}
				}
			}
		}
		return false;
	}
}